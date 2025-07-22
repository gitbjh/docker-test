# Docker 기반 카운트 증가 예제

## 구성
- Front 서버 (Spring Boot, Thymeleaf, 3000번 포트)
- API 서버 (Spring Boot, JDBC, 8080번 포트)
- DB 서버 (MySQL, 3306번 포트)

## 실행 방법
1. `docker-compose up --build` 명령어로 모든 컨테이너를 실행합니다.
2. 브라우저에서 [http://localhost:3000](http://localhost:3000) 접속 후 버튼을 클릭해 카운트를 증가시킬 수 있습니다.

## 폴더 구조
- `front/` : 프론트엔드(Spring Boot, Thymeleaf)
- `api/` : 백엔드 API(Spring Boot, JDBC)
- `docker-compose.yml` : 전체 서비스 오케스트레이션

## DB 정보
- DB 이름: countdb
- 사용자: countuser / countpw
- 테이블: counter (id, value)

## 참고
- 각 서버는 Dockerfile로 빌드되며, jar 파일은 `target/` 폴더에 위치해야 합니다.
- API 서버는 DB가 준비된 후에 실행됩니다.
- DB 초기화는 `api/src/main/resources/schema.sql` 참고 