package com.youngsil.springasync01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringAsync01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAsync01Application.class, args);
    }

}
