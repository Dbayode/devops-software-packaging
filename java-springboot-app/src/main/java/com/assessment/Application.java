package com.devops.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    @Value("${app.env:development}")
    private String environment;

    @Value("${server.port:8080}")
    private String port;

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("ecosystem", "Java/Spring Boot");
        response.put("environment", environment);
        response.put("port", port);
        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
