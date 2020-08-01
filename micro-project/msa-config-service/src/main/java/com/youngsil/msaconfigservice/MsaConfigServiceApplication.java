package com.youngsil.msaconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsaConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaConfigServiceApplication.class, args);
    }

}
