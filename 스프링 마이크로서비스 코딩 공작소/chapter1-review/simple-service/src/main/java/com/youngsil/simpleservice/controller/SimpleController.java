package com.youngsil.simpleservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class SimpleController {

    @RequestMapping("/hello/{firstName}/{lastName}")
    public String hello(@PathVariable("firstName") String firstName,
                        @PathVariable("lastName") String lastName) {

        return "\"username\":\""+firstName+" " +lastName+"\"";
    }
}
