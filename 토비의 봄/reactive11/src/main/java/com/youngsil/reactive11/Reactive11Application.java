package com.youngsil.reactive11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class Reactive11Application {

    public static void main(String[] args) {
        SpringApplication.run(Reactive11Application.class, args);
    }

    @Bean
    ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(1);
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
}
