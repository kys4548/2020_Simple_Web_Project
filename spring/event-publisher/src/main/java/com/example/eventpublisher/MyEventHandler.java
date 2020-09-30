package com.example.eventpublisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyEventHandler {

    @EventListener
    @Async
    public void handler1(MyEvent myEvent) {
        log.info(myEvent.toString()+ 1);
    }

    @EventListener
    @Async
    public void handler2(MyEvent myEvent) {
        log.info(myEvent.toString()+ 2);
    }

    @EventListener
    @Async
    public void handler3(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("새로고침");
    }

    @EventListener
    @Async
    public void handler4(ContextClosedEvent contextClosedEvent) {
        log.info("종료");
    }
}
