package com.example.demo05usingformredirect;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @PostMapping("/redirect")
    public String showResult(@RequestParam("data") String data) {
        return data;
    }
}
