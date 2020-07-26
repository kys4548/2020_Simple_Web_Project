package com.youngsil.simpleservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("hello/{f}/{l}")
    public String hello(@PathVariable String f, @PathVariable String l) {
        return "{\"username\":\"" + f +" " +l +"\"}";
    }
}
