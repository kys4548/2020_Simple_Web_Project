package com.youngsil.reactive04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CallbackFutureTask extends FutureTask<String> {
    SuccessCallback sc;
    ExceptionCallback ec;

    public CallbackFutureTask(Callable<String> callable,
                              SuccessCallback sc, ExceptionCallback ec) {
        super(callable);
        this.sc = sc;
        this.ec = ec;
    }

    @Override
    protected void done() {
        try {
            sc.onSuccess(get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            ec.onError(e.getCause());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService es = Executors.newCachedThreadPool();

        final CallbackFutureTask f = new CallbackFutureTask(() -> {
            Thread.sleep(2000);
            log.info("Async");
            return "Hello";
        }, s -> {
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");

        }, s -> {
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");
            System.out.println("test");

        });

        es.execute(f);
        es.shutdown();
    }
}

@FunctionalInterface
interface SuccessCallback {
    void onSuccess(String result);
}

@FunctionalInterface
interface ExceptionCallback {
    void onError(Throwable t);
}