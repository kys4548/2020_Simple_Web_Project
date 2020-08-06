package com.youngsil.reactive11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(10);

        CompletableFuture
                .supplyAsync(() -> {
                    log.info("runAsync");
                    //if (1==1) throw new RuntimeException();
                    return 1;
                }, es)
                .thenApplyAsync(i -> {
                    log.info("thenRun {}", i);
                    return i + 1;
                }, es)
                .exceptionally(e -> -10)
                .thenAccept((i2) -> {
                    log.info("thenRun {}", i2);
                });
        log.info("exit");

        ForkJoinPool.commonPool().shutdown();
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);

    }
}
