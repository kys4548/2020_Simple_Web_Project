package com.youngsil.reactive09;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@SuppressWarnings("deprecation")
public class MyController {

    public static final String URL1 = "http://localhost:8081/service?req={req}";
    public static final String URL2 = "http://localhost:8081/service2?req={req}";
    @Autowired
    MyService myService;

//    RestTemplate restTemplate = new RestTemplate();
    AsyncRestTemplate rt = new AsyncRestTemplate(
            new Netty4ClientHttpRequestFactory(
                new NioEventLoopGroup(1)));


    @GetMapping("/rest")
    public DeferredResult<String> rest(int idx) {
        DeferredResult<String> dr = new DeferredResult<>();

        final ListenableFuture<ResponseEntity<String>> f1 = rt.getForEntity(
                URL1,
                String.class,
                "hello " + idx
        );

        f1.addCallback(
                s -> {
                    final ListenableFuture<ResponseEntity<String>> f2 = rt.getForEntity(
                            URL2,
                            String.class,
                            s.getBody()
                    );
                    f2.addCallback(
                            s2 -> {
                                final ListenableFuture<String> res = myService.work(s2.getBody());
                                res.addCallback(
                                        dr::setResult,
                                        e -> dr.setErrorResult(e.getMessage())
                                );
                            },
                            e -> dr.setErrorResult(e.getMessage())
                    );
                },
                e -> dr.setErrorResult(e.getMessage()));

        return dr;
    }
}
