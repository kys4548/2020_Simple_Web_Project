package com.youngsil.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemoteApplication {

    public static void main(String[] args) {
        System.setProperty("SERVER.PORT", "8081");
        System.setProperty("server.tomcat.max-threads", "1000");
        SpringApplication.run(RemoteApplication.class, args);
    }
}
