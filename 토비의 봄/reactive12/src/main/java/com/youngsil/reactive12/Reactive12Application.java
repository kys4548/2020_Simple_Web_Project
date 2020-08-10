package com.youngsil.reactive12;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
public class Reactive12Application {

    public static void main(String[] args) {
        log.info("============== Main Start");
        SpringApplication.run(Reactive12Application.class, args);
    }

}
