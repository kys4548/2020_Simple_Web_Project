package com.example.springboot02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    Environment environment;

    @Autowired
    MessageSource messageSource;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));

        System.out.println(messageSource.getMessage("greeting", new String[] {"youngsil"}, Locale.getDefault()));


        System.out.println(environment.getProperty("app.about"));

        applicationEventPublisher.publishEvent(new MyEvent(100, this));

        //classpath의 root는 기본으로 target.classes이다.
        Resource resource1 = resourceLoader.getResource("classpath:test1.txt");
        System.out.println(resource1.exists());
        Resource resource2 = resourceLoader.getResource("classpath:test2.txt");
        System.out.println(resource2.exists());
        System.out.println(resource2.getDescription());
        System.out.println(resource2.getURL());
    }
}
