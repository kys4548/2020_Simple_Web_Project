package com.youngsil.securitytest;

import com.youngsil.securitytest.Account;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;

@Data
public class AccountForm {

    private String username;
    private String password;

    public Account toAccount(PasswordEncoder passwordEncoder) {
        final Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));

        return account;
    }
}
