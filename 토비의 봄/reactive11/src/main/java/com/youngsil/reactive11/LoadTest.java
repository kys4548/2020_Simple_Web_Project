package com.youngsil.reactive11;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/rest?idx={idx}";

        CyclicBarrier cyclicBarrier = new CyclicBarrier(101);

        for(int i=0; i<100; i++) {
            executorService.execute(() -> {
                int idx = counter.addAndGet(1);

                StopWatch stopWatch = new StopWatch();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                log.info("Thread {}", idx);

                stopWatch.start();
                final String res = rt.getForObject(url, String.class, idx);
                stopWatch.stop();

                log.info("{} {} / {}", idx, stopWatch.getTotalTimeSeconds(), res);
            });
        }

        StopWatch main = new StopWatch();

        cyclicBarrier.await();

        main.start();

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        main.stop();
        log.info("Total : {} ", main.getTotalTimeSeconds());
    }
}
