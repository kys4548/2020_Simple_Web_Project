package com.youngsil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Autowired
    YoungsilProperties properties;

    @Autowired
    private String hello;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info(hello);
        logger.info(properties.getName());
        logger.debug(properties.getFull());
    }
}
