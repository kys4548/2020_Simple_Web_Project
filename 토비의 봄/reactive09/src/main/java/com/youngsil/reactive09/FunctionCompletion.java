package com.youngsil.reactive09;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.function.Function;

public class FunctionCompletion extends Completion {

    private Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> function;

    public FunctionCompletion(Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> function) {
        this.function = function;
    }

    @Override
    protected void run(ResponseEntity<String> re) {
        function.apply(re).addCallback(this::complete, this::error);
    }
}
