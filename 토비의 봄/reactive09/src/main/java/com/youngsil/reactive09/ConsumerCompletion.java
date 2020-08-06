package com.youngsil.reactive09;

import org.springframework.http.ResponseEntity;

import java.util.function.Consumer;

public class ConsumerCompletion extends Completion {

    private Consumer<ResponseEntity<String>> consumer;

    public ConsumerCompletion(Consumer<ResponseEntity<String>> consumer) {
        this.consumer = consumer;
    }

    @Override
    protected void run(ResponseEntity<String> re) {
        consumer.accept(re);
    }
}
