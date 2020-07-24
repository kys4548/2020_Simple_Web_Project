package com.youngsil.msareviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsaReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaReviewServiceApplication.class, args);
    }

}
