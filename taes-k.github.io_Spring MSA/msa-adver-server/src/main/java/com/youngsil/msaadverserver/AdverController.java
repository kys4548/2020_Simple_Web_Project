package com.youngsil.msaadverserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdverController {

    @RequestMapping("/")
    public String getAdver() {
        return "adver information";
    }
}
