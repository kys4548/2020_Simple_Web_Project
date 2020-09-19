package com.example.tobyspringchapter13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class TobySpringChapter13Application {

    @RestController
    @Slf4j
    public static class MyController {

        @GetMapping("/")
        Mono<String> hello() {
            log.info("pos1");
            String msg = generateHello();
            Mono<String> m = Mono.just(msg).doOnNext(log::info).log();
            String msg2 = m.block();
            log.info("pos2 {}", msg2);
            return m;
        }

        private String generateHello() {
            log.info("method hello");
            return "Hello Mono";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(TobySpringChapter13Application.class, args);
    }

}
