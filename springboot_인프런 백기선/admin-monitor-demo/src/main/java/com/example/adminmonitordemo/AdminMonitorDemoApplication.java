package com.example.adminmonitordemo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminMonitorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminMonitorDemoApplication.class, args);
    }

}
