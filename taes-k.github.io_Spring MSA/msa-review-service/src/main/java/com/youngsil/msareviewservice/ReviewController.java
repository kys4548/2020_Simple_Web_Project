package com.youngsil.msareviewservice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ReviewController {

    @GetMapping("/")
    public String getReview() {
        return "review information";
    }

    @GetMapping("/")
    public String setReview() {
        final WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8090/api/news")
                .build();

        final Mono<String> response = client.get().uri("/review/add?newsId=333").retrieve().bodyToMono(String.class);
        System.out.println("Response : " + response.block());

        return "write review";
    }

}
