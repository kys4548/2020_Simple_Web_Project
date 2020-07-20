package com.yougsil.demospringsecurityform.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if(principal == null) {
            model.addAttribute("message", "hello spring security : index");
        } else {
            model.addAttribute("message", "hello " + principal.getName());
        }
        return "index";
    }

    @GetMapping("info")
    public String info(Model model) {
        model.addAttribute("message", "hello spring security : info");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dash(Model model, Principal principal) {
        model.addAttribute("message", "hello spring security : dash");
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "hello spring security : admin");
        return "admin";
    }
}
