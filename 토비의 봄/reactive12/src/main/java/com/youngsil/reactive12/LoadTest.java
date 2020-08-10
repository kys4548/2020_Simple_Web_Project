package com.youngsil.reactive12;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        RestTemplate rt = new RestTemplate();

        ExecutorService es = Executors.newFixedThreadPool(100);
        AtomicInteger counter = new AtomicInteger(0);
        CyclicBarrier barrier = new CyclicBarrier(101);

        for(int i=0; i<100; i++) {
            es.submit(() -> {
               int idx = counter.addAndGet(1);
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                log.info("Thread {} ", idx);

                StopWatch sw = new StopWatch();

                sw.start();
                final String res = rt.getForObject("http://localhost:8080/rest?idx={idx}", String.class, idx);
                sw.stop();
                log.info("{} {} / {} ", idx, sw.getTotalTimeSeconds(), res);

                return null;
            });
        }

        barrier.await();
        StopWatch main = new StopWatch();
        main.start();
        es.shutdown();
        es.awaitTermination(100, TimeUnit.SECONDS);

        main.stop();
        log.info("Total : {} ", main.getTotalTimeSeconds());
    }
}
