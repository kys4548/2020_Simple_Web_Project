package com.example.containsmystarter;

import com.youngsil.SingleMan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
public class ContainsMyStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainsMyStarterApplication.class, args);
    }

}
