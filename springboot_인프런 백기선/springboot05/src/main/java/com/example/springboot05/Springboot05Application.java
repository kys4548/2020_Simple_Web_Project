package com.example.springboot05;

import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class Springboot05Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Springboot05Application.class);
        app.addListeners(new SampleListener());
        app.run(args);
    }
}