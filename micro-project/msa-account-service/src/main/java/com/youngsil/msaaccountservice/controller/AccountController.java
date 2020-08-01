package com.youngsil.msaaccountservice.controller;

import com.youngsil.msaaccountservice.config.PropertyConfig;
import com.youngsil.msaaccountservice.model.Account;
import com.youngsil.msaaccountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final PropertyConfig propertyConfig;
    private final AccountRepository accountRepository;

    @GetMapping("/message")
    public String message() {
        return propertyConfig.getMessage();
    }

    @GetMapping("/create/{username}/{password}")
    public Account create(@ModelAttribute Account account) {
        return accountRepository.save(account);
    }
}
