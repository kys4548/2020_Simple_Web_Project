package com.example.demoinflearnrestapi.accounts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void findByUsername() {

        //Given
        final String username = "youngsil";
        final String password = "1234";
        final String email = "kys4548@naver.com";

        final Account account = Account.builder()
                .email(email)
                .username(username)
                .password(password)
                .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
                .build();

        accountService.saveAccount(account);

        //When
        UserDetailsService userDetailsService = (UserDetailsService)accountService;
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        //Then
        assertTrue(passwordEncoder.matches(password, userDetails.getPassword()));
    }

    @Test
    public void findByUsernameFail() {
        final String username = "randomName";
        accountService.findByUsername(username);

        assertThrows(UsernameNotFoundException.class, () -> accountService.loadUserByUsername(username));
    }
}