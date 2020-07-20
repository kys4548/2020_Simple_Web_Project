package com.example.springboot05;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    public void handler(MyEvent event) {
        System.out.println(event.toString());
    }
}
