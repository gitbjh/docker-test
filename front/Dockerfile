FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/front-server.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "app.jar"] 