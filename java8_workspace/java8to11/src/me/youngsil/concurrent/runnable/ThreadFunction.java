package me.youngsil.concurrent.runnable;

public class ThreadFunction {

    public static void main(String[] args) throws InterruptedException {
        //sleep를 통해 재우는 법
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread : " + Thread.currentThread().getName());
        });
        thread.start();


        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        thread1.start();

        System.out.println("main : " + Thread.currentThread().getName());
        //쓰레드 기다리기 : 다음줄 실행 X
        thread1.join();
        System.out.println("test");
        thread1.interrupt();

    }
}
