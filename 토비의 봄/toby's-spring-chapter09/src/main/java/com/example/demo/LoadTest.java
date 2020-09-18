package com.example.demo;

import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadTest {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);
        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/rest?idx={idx}";

        CyclicBarrier cb = new CyclicBarrier(101);

        for(int i=0; i<100; i++) {
            es.submit(() -> {
                int idx = counter.addAndGet(1);
                StopWatch sw = new StopWatch();

                cb.await();
                sw.start();
                String res = rt.getForObject(url, String.class, idx);
                sw.stop();
                System.out.println(res + " " + sw.getTotalTimeSeconds());
                return null;
            });
        }

        StopWatch totalTime = new StopWatch();
        cb.await();
        totalTime.start();

        es.shutdown();
        es.awaitTermination(100, TimeUnit.SECONDS);
        totalTime.stop();
        System.out.println("전체 시간 : " + totalTime.getTotalTimeSeconds());
    }
}
