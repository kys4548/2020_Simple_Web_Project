package com.youngsil.reactive11;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.CompletableFuture;

@RestController
@SuppressWarnings("deprecation")
public class MyController {
    AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

    @Autowired
    MyService myService;

    static final String URL1 = "http://localhost:8081/service1?req={req}";
    static final String URL2 = "http://localhost:8081/service2?req={req}";

    @GetMapping("/rest")
    public DeferredResult<String> rest(int idx) {
        DeferredResult<String> dr = new DeferredResult<>();

        toCF(rt.getForEntity(URL1, String.class, "hello " + idx))
                .thenCompose(s -> toCF(rt.getForEntity(URL2, String.class, s.getBody())))
                .thenCompose(s2 -> toCF(myService.work(s2.getBody())))
                .thenAccept(s3 -> dr.setResult(s3)); 


        return dr;
    }

    <T> CompletableFuture<T> toCF(ListenableFuture<T> lf) {
        final CompletableFuture<T> completableFuture = new CompletableFuture<>();
        lf.addCallback(completableFuture::complete, completableFuture::completeExceptionally);
        return completableFuture;
    }
}
