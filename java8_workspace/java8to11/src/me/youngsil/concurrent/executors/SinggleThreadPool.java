package me.youngsil.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinggleThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName());
            }
        });

        //runnable만 가능
        executorService.execute( () -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });

        //runnable, callable 가능
        executorService.submit( () -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });


        //무언가 돌고있어도 상관없이 죽인다.
        executorService.shutdownNow();

        //직접 종료해주지 않으면 계속 기다리고 있음. (이벤트 방식과 비슷하네)
        //graceful shutdown
        //현재 작업중인 것이 있다면 그것까지 완료하고 종료료
       executorService.shutdown();
    }
}