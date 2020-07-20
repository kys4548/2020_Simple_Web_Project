package com.example.springboot06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    YoungsilProperties youngsilProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(youngsilProperties.getFullName());
        System.out.println(youngsilProperties.getAge());
        System.out.println(youngsilProperties.getSessionTimeout());
    }
}
