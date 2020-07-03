package me.youngsil.concurrent.runnable;

public class App {
    /**
     * 스레드의 실행 순서를 보장하지 못한다.
     */
    public static void main(String[] args) {
        //Thread 사용법
        MyThread myThread = new MyThread();
        myThread.start();

        //Runnable 사용법
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread2 = new Thread(myRunnable);
        myThread2.start();

        Thread myThread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("RunnableThread2 : " + Thread.currentThread());
            }
        });
        myThread3.start();

        //Java8 버전 이후
        Thread myThread4 = new Thread(() -> System.out.println("java8 Update Thread : " + Thread.currentThread()));
        myThread4.start();



        System.out.println("main : " + Thread.currentThread());
    }
}
