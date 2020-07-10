package com.youngsil.springbootjpa.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/create")
    public Account create() {
        Account account = new Account();
        account.setUsername("youngsil");
        account.setPassword("pass");
        final Account save = accountRepository.save(account);

        return save;
    }
}
