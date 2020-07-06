package me.youngsil.concurrent.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleScheduledThread {

    public static void main(String[] args) {


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("hello"), 1, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        System.out.println("test");

    }
    public static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
