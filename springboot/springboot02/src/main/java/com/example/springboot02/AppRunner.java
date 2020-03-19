package com.example.springboot02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(messageSource.getMessage("greeting", new String[] {"youngsil"}, Locale.KOREA));
        System.out.println(messageSource.getMessage("greeting", new String[] {"youngsil"}, Locale.getDefault()));
    }
}
