package com.example.demoinflearnrestapi.index;

import com.example.demoinflearnrestapi.events.EventController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController("/")
public class IndexController {

    @GetMapping("/api")
    public RepresentationModel index() {

        RepresentationModel model = new RepresentationModel();
        model.add(linkTo(EventController.class).withRel("events"));

        return model;
    }
}
