package com.example.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontController {
    @Value("${api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index(Model model) {
        Integer count = restTemplate.getForObject(apiUrl, Integer.class);
        model.addAttribute("count", count);
        return "index";
    }

    @PostMapping("/inc1")
    public String inc1() {
        restTemplate.postForObject(apiUrl + "/inc1", null, Integer.class);
        return "redirect:/";
    }

    @PostMapping("/inc2")
    public String inc2() {
        restTemplate.postForObject(apiUrl + "/inc2", null, Integer.class);
        return "redirect:/";
    }
} 