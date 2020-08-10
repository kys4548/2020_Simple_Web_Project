package com.youngsil.reactive12;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @Async
    public CompletableFuture<String> work(String req) {
        return CompletableFuture.completedFuture(req + "/ asyncwork");
    }
}
