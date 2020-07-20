package me.youngsil.concurrent.executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());
        executorService.execute(getRunnable());

        executorService.shutdown();




//        /**
//         * executorService가 Thread Pool과 Blocking Queue를 관리
//         * 아래 예시에서는 3개의 Thread를 가진 Thread Pool을 생성
//         * 요청이 올때마다 Blocking Queue에 넣고 쉬고있는 Thead에 시킨다.
//         * Thread Pool에 모든 Thread가 실행되고 있을 때 Block Queue는 대기한다.
//         */
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        for(int i=0; i<20; i++) {
//            executorService.execute( () -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//        executorService.shutdown();
//
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
//
//        for(int i=0; i<20; i++) {
//            executorService1.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//        executorService1.shutdown();
    }

    public static Runnable getRunnable() {
        return () -> System.out.println(Thread.currentThread());
    }
}
