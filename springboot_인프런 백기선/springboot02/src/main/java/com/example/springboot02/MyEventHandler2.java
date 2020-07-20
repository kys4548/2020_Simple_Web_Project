package com.example.springboot02;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler2 {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE +2)
    @Async //비동기식으로 작동 요구
    public void handler(MyEvent event) {
        System.out.println("이벤트2 발생");
    }
}
