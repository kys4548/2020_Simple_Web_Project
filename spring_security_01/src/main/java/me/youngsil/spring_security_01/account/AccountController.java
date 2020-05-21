package me.youngsil.spring_security_01.account;

import javassist.tools.rmi.Sample;
import lombok.RequiredArgsConstructor;
import me.youngsil.spring_security_01.form.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(@ModelAttribute AccountCreateDto accountCreateDto) {
        return accountService.createNew(accountCreateDto.getUsername(), accountCreateDto.getPassword(), accountCreateDto.getRole());
    }
}
