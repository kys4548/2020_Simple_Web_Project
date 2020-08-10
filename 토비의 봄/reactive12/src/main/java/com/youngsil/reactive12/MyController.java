package com.youngsil.reactive12;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class MyController {

    @Autowired
    MyService myService;

    WebClient webClient = WebClient.create();

    static final String URL1 = "http://localhost:8081/service1?req={req}";
    static final String URL2 = "http://localhost:8081/service2?req={req}";

    @GetMapping("/rest")
    public Mono<String> rest(int idx) {
        log.info("================= Controller start");
        return webClient.get().uri(URL1, idx).exchange()
                .flatMap(cr -> cr.bodyToMono(String.class))
                .flatMap(s -> webClient.get().uri(URL2, s).exchange())
                .flatMap(cr -> cr.bodyToMono(String.class))
                .doOnNext(log::info)
                .flatMap(s -> Mono.fromCompletionStage(myService.work(s)))
                .doOnNext(log::info);


    }

}
