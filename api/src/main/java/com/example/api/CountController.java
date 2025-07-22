package com.example.api;

import org.springframework.web.bind.annotation.*;
import java.sql.*;

@RestController
@RequestMapping("/api/count")
public class CountController {
    private final String url = "jdbc:mysql://db:3306/countdb";
    private final String user = "countuser";
    private final String password = "countpw";

    @GetMapping
    public int getCount() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT value FROM counter WHERE id=1")) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @PostMapping("/inc1")
    public int increment1() {
        return increment(1);
    }

    @PostMapping("/inc2")
    public int increment2() {
        return increment(2);
    }

    private int increment(int amount) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE counter SET value = value + ? WHERE id=1");
            ps.setInt(1, amount);
            ps.executeUpdate();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT value FROM counter WHERE id=1");
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
} 