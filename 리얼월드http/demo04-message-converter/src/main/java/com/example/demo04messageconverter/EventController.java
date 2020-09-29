package com.example.demo04messageconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    ConversionService conversionService;

    @RequestMapping("event/{event}")
    public Event getEvent(@PathVariable Event event) {
        System.out.println(event.toString());
        return event;
    }
}
