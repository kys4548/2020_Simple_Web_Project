package com.example.springboot03;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class MyEventHandler2 {

    @EventListener
    public void handler2(MyEvent event) {
        System.out.println("event Handler2");
    }
}
