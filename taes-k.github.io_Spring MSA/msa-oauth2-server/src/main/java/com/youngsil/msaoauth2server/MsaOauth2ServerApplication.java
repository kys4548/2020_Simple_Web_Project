package com.youngsil.msaoauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class MsaOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaOauth2ServerApplication.class, args);
    }

}
