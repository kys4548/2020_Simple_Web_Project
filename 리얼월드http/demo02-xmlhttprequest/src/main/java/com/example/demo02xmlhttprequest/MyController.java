package com.example.demo02xmlhttprequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/")
    public String home() {
        return "ㅎㅇㅎㅇ";
    }

    @GetMapping("/json")
    public String getJson(@RequestParam("message") EventMessage eventMessage) throws JsonProcessingException {
        logger.info(eventMessage.toString());
        return objectMapper.writeValueAsString(eventMessage);
    }

    @PostMapping("/jsonObject")
    public String postJsonObject(@RequestBody EventMessage eventMessage) throws JsonProcessingException {
        logger.info(eventMessage.toString());
        return objectMapper.writeValueAsString(eventMessage);
    }

    @PostMapping("/jsonParam")
    public String getJsonParam(@RequestParam("message") EventMessage eventMessage) throws JsonProcessingException {
        logger.info(eventMessage.toString());
        return objectMapper.writeValueAsString(eventMessage);
    }
}
