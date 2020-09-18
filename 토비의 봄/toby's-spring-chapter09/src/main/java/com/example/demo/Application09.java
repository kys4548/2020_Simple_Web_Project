package com.example.demo;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@SuppressWarnings("deprecation")
@EnableAsync
public class Application09 {

    @RestController
    public static class MyController {
        @Autowired
        MyService myService;

        AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        @GetMapping("/rest")
        public DeferredResult<String> rest(int idx) {
            DeferredResult<String> dr = new DeferredResult<>();
            ListenableFuture<ResponseEntity<String>> lf = rt.getForEntity("http://localhost:8081/service?req={req}", String.class, "hello " + idx);

            lf.addCallback(
                    s -> {
                        ListenableFuture<ResponseEntity<String>> lf2 = rt.getForEntity("http://localhost:8081/service2?req={req}", String.class, s.getBody());
                        lf2.addCallback(
                                s2 -> {
                                    ListenableFuture<String> lf3 = myService.work(s2.getBody());
                                    lf3.addCallback(
                                            s3 -> {
                                                dr.setResult(s3);
                                            },
                                            e -> {
                                                dr.setErrorResult(e.getMessage());
                                            }
                                    );
                                },
                                e -> {
                                    dr.setErrorResult(e.getMessage());
                                }
                        );
                    },
                    e -> {
                        dr.setErrorResult(e.getMessage());
                    });
            return dr;
        }
    }

    @Service
    public static class MyService {
        @Async
        public ListenableFuture<String> work(String req) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new AsyncResult<>(req + " /MyService");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application09.class, args);
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor te = new ThreadPoolTaskExecutor();
        te.setCorePoolSize(1);
        te.setQueueCapacity(100);
        te.setMaxPoolSize(50);
        te.initialize();
        return te;
    }
}
