package com.youngsil.msaaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MsaAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaAccountServiceApplication.class, args);
    }

}
