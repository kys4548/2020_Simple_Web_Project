package com.youngsil.remote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController {

    @GetMapping("/service1")
    public String service(String req) throws InterruptedException {
        Thread.sleep(2000);
        return req + " /service1 ";
    }

    @GetMapping("/service2")
    public String service2(String req) throws InterruptedException {
        Thread.sleep(2000);
        return req + " /service2 ";
    }
}
