package com.example.springdata02.Post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostRepositoryTestConfig {

    @Bean
    public ApplicationListener<PostPublishedEvent> postListener() {
        return postPublishedEvent -> System.out.println(postPublishedEvent.getPost().getTitle());
    }
}
