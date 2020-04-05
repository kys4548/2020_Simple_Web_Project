package com.example.springdata01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
@Import(YoungsilRegistrar.class)
//@EnableJpaRepositories
public class Springdata01Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Springdata01Application.class, args);
    }

}
