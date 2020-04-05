package com.example.springdata02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = MyRepositoryImpl.class)
public class Springdata02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdata02Application.class, args);
    }

}
