package com.youngsil.remote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RemoteController {

    @GetMapping("/service1")
    public Mono<String> service1(String req) throws InterruptedException {
        Thread.sleep(1000);
        return Mono.just(req + " /service1 ");
    }

    @GetMapping("/service2")
    public Mono<String> service2(String req) throws InterruptedException {
        Thread.sleep(1000);
        return Mono.just(req + " /service2 ");
    }
}
