package com.example.springdata04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(repositoryBaseClass = MyRepository2Impl.class)
public class Springdata04Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdata04Application.class, args);
    }

}
