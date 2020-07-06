package com.example.containsmystarter;

import com.youngsil.SingleMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    SingleMan singleMan;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(singleMan.toString());
    }
}
