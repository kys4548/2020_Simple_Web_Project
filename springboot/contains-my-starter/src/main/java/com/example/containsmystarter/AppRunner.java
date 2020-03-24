package com.example.containsmystarter;

import me.youngsil.Coupleman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    Coupleman coupleman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(coupleman.toString());

    }
}
