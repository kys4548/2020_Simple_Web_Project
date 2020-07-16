package com.youngsil.securitytest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String processRegister(AccountForm accountForm, Errors errors) {
        if(errors.hasErrors()) {
            return "register";
        }
        accountRepository.save(accountForm.toAccount(passwordEncoder));
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
