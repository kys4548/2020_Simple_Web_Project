package com.youngsil.msanewsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsaNewsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaNewsServiceApplication.class, args);
    }

}
