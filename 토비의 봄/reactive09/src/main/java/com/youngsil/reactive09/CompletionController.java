package com.youngsil.reactive09;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@SuppressWarnings("deprecation")
public class CompletionController {

    public static final String URL1 = "http://localhost:8081/service?req={req}";
    public static final String URL2 = "http://localhost:8081/service2?req={req}";

    @Autowired
    MyService myService;

    AsyncRestTemplate rt = new AsyncRestTemplate(
            new Netty4ClientHttpRequestFactory(
                    new NioEventLoopGroup(1)));

    @GetMapping("/rest2")
    public DeferredResult<String> rest2(int idx) {
        DeferredResult<String> dr = new DeferredResult<>();

        Completion.
                from(rt.getForEntity(URL1, String.class, "hello" + idx))
                .andApply(re -> rt.getForEntity(URL2, String.class, re.getBody()))
                .andError(dr::setErrorResult)
                .andAccept(re -> dr.setResult(re.getBody()));


        return dr;
    }
}
