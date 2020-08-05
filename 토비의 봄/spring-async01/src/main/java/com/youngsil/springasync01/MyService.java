package com.youngsil.springasync01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@Slf4j
public class MyService {

    @Async
    public ListenableFuture<String> hello() throws InterruptedException {
        log.info("service: hello()");
        Thread.sleep(2000);
        return new AsyncResult<>("Hello");
    }
}
