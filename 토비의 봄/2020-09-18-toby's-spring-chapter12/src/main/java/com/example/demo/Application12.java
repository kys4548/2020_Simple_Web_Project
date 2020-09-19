package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
public class Application12 {

    @RestController
    public static class MyController {
        @Autowired
        MyService myService;

        WebClient webClient = WebClient.create();

        @GetMapping("/rest")
        public Mono<String> rest(int idx) {
            return webClient
                    .get().uri("http://localhost:8080/service1?req={req}", idx).exchange()
                    .flatMap(cr -> cr.bodyToMono(String.class))
                    .flatMap(req -> webClient.get().uri("http://localhost:8080/service2?req={req}", req).exchange())
                    .flatMap(cr ->cr.bodyToMono(String.class))
                    .flatMap(req -> Mono.fromCompletionStage(myService.work(req)));
        }
    }

    @Service
    public static class MyService {
        @Async
        public CompletableFuture<String> work(String req) {
            System.out.println(Thread.currentThread());
            return CompletableFuture.completedFuture(req + " MyService");
        }
    }

    @RestController
    public static class RemoteController {
        @GetMapping("service1")
        public String service1(String req) throws InterruptedException {
            Thread.sleep(1000);
            return req + " service1";
        }

        @GetMapping("service2")
        public String service2(String req) throws InterruptedException {
            Thread.sleep(1000);
            return req + " service2";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application12.class, args);
    }

//    @Bean
//    ThreadPoolTaskExecutor threadPoolTaskExecutor() {
//        ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
//        te.setCorePoolSize(1);
//        te.setQueueCapacity(100);
//        te.setMaxPoolSize(50);
//        te.initialize();
//
//        return te;
//    }
}
