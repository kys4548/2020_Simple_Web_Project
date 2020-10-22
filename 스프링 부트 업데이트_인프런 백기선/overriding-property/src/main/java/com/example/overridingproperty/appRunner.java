package com.example.overridingproperty;

import com.example.solomanproperty.SoloMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class appRunner implements ApplicationRunner {

    @Autowired
    SoloMan soloMan;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-----------------------------");
        System.out.println(soloMan.getName());
        System.out.println("=============================");
    }
}
