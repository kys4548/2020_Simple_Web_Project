package com.youngsil.msanewsservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class NewsController {
    @RequestMapping("/")
    public String getNews() {
        return "news information";
    }

    @RequestMapping("/review/add")
    public Mono<ResponseEntity> addReviewCount(@RequestParam("newsId") int newsId) {
        System.out.println("add news Review Count / news Id : "+newsId);
        return Mono.just(ResponseEntity.ok().build());
    }
}
