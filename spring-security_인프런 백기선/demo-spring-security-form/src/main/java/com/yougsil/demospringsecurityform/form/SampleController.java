package com.yougsil.demospringsecurityform.form;

import com.yougsil.demospringsecurityform.account.AccountContext;
import com.yougsil.demospringsecurityform.account.AccountRepository;
import com.yougsil.demospringsecurityform.common.SecurityLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.concurrent.Callable;

@Controller
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    AccountRepository accountRepository;

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
        System.out.println(principal.getClass());
        sampleService.dashboard();
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "hello spring security : admin");
        return "admin";
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("message", principal.getName());
        return "user";
    }

    @GetMapping("/async-handler")
    @ResponseBody
    public Callable<String> asyncHandler() {
        SecurityLogger.log("MVC");
        return () -> {
            SecurityLogger.log("Callable");
            return "Async Handler";
        };
    }

    @GetMapping("/async-service")
    @ResponseBody
    public String asyncService() {
        SecurityLogger.log("MVC, before async service");
        sampleService.asyncService();
        SecurityLogger.log("MVC, after async service");
        return "Async Service";
    }

}
