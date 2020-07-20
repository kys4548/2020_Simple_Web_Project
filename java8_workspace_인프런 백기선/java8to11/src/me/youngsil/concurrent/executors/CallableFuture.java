package me.youngsil.concurrent.executors;

import java.util.List;
import java.util.concurrent.*;

public class CallableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> c1 = () -> {
            Thread.sleep(1000);
          return "3";
        };

        Callable<String> c2 = () -> {
            Thread.sleep(1000);
            return "2";
        };

        Callable<String> c3 = () -> {
            Thread.sleep(1000);
            return "1";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> futures = executorService.invokeAll(List.of(c1, c2, c3));

        for(Future<String> f : futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        String s = executorService1.invokeAny(List.of(c1, c2, c3));
        System.out.println("s = " + s);
        executorService1.shutdown();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        System.out.println("start");
//        Callable<String> callable = () -> {
//            Thread.sleep(1000);
//            return "process";
//        };
//
//
//        Future<String> future = executorService.submit(callable);
//
//        System.out.println(future.isDone());
//
//        //get을 만난순간 멈춘다.
//        try {
//            future.cancel(true);
//            System.out.println(future.get());
//            System.out.println(future.isDone());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
//        System.out.println("end");
    }
}
