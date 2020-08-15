package com.example.springaopproxy;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleApplicationRunner implements ApplicationRunner {

    @Override
    @LogExecutionTime
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("test");
        return;
    }
}
