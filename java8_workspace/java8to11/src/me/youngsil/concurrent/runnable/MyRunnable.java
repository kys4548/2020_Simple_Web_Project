package me.youngsil.concurrent.runnable;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable Thread : " + Thread.currentThread());
    }
}
