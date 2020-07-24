package com.youngsil.msaadverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsaAdverServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaAdverServerApplication.class, args);
    }

}
