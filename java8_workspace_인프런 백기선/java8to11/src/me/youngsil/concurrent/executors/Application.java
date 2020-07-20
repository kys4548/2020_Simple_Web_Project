package me.youngsil.concurrent.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello");
            return "hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("world");
            return "world";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("finish");
            return "finish";
        });

        future1.thenApply(hello -> {
            return future2.thenApply(world -> {
                System.out.println(hello +" "+ world);
                return hello+world;
            });
        });

        future1.thenCombine(future2, (f1, f2) -> {
            System.out.println(f1 + " + " + f2);
            return f1 +" " + f2;
        });

        CompletableFuture.allOf(future1, future2, future3)
                .thenAccept(System.out::println);

        Thread.sleep(5000);
    }
}