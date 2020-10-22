package com.example.overridingproperty;

import com.example.solomanproperty.SoloMan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OverridingPropertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OverridingPropertyApplication.class, args);
    }

//    @Bean
//    public SoloMan soloMan() {
//        SoloMan soloMan = new SoloMan();
//        soloMan.setName("youngsil");
//        return soloMan;
//    }
}
