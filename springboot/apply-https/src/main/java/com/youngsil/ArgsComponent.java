package com.youngsil;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgsComponent {

    public ArgsComponent(ApplicationArguments arguments) {
        System.out.println("foo : " + arguments.containsOption("foo"));
        System.out.println("Bar : " + arguments.containsOption("bar"));
    }
}
