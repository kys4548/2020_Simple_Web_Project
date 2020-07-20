package com.example.springboot03;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class MyEventHandler1 {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void handler1(MyEvent event) {
        System.out.println("eventHandler1");
    }
}
