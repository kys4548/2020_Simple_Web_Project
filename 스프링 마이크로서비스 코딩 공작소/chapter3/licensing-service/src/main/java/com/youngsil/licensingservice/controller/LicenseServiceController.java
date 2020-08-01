package com.youngsil.licensingservice.controller;

import com.youngsil.licensingservice.config.ServiceConfig;
import com.youngsil.licensingservice.model.Account;
import com.youngsil.licensingservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LicenseServiceController {

    private final ServiceConfig serviceConfig;

    private final AccountRepository accountRepository;


    @RequestMapping("/message")
    public String message() {
        return serviceConfig.getProperty();
    }

    @RequestMapping("/account/{username}/{password}")
    public Account createAccount(@ModelAttribute Account account) {

        return accountRepository.save(account);
    }
}
