package com.example.springdata05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware")
public class Springdata05Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdata05Application.class, args);
    }

}
