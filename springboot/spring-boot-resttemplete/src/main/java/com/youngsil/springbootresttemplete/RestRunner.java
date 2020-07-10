package com.youngsil.springbootresttemplete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

//@Component
public class RestRunner implements ApplicationRunner {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final RestTemplate build = restTemplateBuilder.build();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final String helloResult = build.getForObject("/hello", String.class);

        final String worldResult = build.getForObject("/hello", String.class);


        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
