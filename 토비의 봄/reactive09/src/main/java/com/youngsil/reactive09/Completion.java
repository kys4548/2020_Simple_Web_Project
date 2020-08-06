package com.youngsil.reactive09;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.function.Consumer;
import java.util.function.Function;

class Completion {

    protected Completion next;

    public static Completion from(ListenableFuture<ResponseEntity<String>> lf) {
        final Completion completion = new Completion();
        lf.addCallback(completion::complete, completion::error);
        return completion;
    }

    protected void error(Throwable e) {
        if(next != null) next.error(e);
    }

    protected void complete(ResponseEntity<String> re) {
        if(next != null) next.run(re);
    }

    protected void run(ResponseEntity<String> re) { }

    public Completion andApply(Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> function) {
        final Completion completion = new FunctionCompletion(function);
        this.next = completion;
        return completion;
    }

    public void andAccept(Consumer<ResponseEntity<String>> consumer) {
        this.next =  new ConsumerCompletion(consumer);
    }

    public Completion andError(Consumer<Throwable> consumer) {
        Completion completion = new ErrorCompletion(consumer);
        this.next = completion;
        return completion;
    }
}