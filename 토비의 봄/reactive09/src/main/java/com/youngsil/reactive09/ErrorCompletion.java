package com.youngsil.reactive09;

import org.springframework.http.ResponseEntity;

import java.util.function.Consumer;

public class ErrorCompletion extends Completion{

    private Consumer<Throwable> consumer;

    public ErrorCompletion(Consumer<Throwable> consumer) {
        this.consumer = consumer;
    }

    @Override
    protected void run(ResponseEntity<String> re) {
        if(next != null) next.run(re);
    }

    @Override
    protected void error(Throwable e) {
        consumer.accept(e);
    }
}
