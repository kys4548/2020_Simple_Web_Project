package com.example.springboot12;

import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.*;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public Hello hello() {
        Hello hello = new Hello();
        hello.setPrefix("Hey, ");
        hello.setName("Youngsil");

        EntityModel<Hello> helloEntityModel = new EntityModel<>(hello);
        helloEntityModel.add((Iterable<Link>) linkTo(""));

        return hello;
    }
}
