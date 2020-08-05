package com.youngsil.reactive09;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@NoArgsConstructor
class Completion {

    private Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn;
    private Completion next;
    private Consumer<ResponseEntity<String>> con;

    public Completion(Consumer<ResponseEntity<String>> con) {
        this.con = con;
    }

    public Completion(Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn) {
        this.fn = fn;
    }

    public static Completion from(ListenableFuture<ResponseEntity<String>> lf) {
        final Completion completion = new Completion();

        lf.addCallback(completion::complete, completion::error);

        return completion;
    }

    private void error(Throwable throwable) {
        log.info("error : " + throwable.getMessage());
    }

    private void complete(ResponseEntity<String> re) {
        if(next != null) next.run(re);
    }

    private void run(ResponseEntity<String> re) {
        if(con != null) con.accept(re);
        else if(fn != null) {
            fn.apply(re).addCallback(this::complete, this::error);
        }
    }

    public Completion andApply(Function<ResponseEntity<String>, ListenableFuture<ResponseEntity<String>>> fn) {
        final Completion completion = new Completion(fn);

        this.next = completion;
        return completion;
    }

    public void andAccept(Consumer<ResponseEntity<String>> con) {
        this.next = new Completion(con);
    }
}