package com.example.demoinflearnrestapi.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account saveAccount(Account account) {
        account.passwordEncode(passwordEncoder);
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Account account = accountRepository.findByUsername(username)
                 .orElseThrow(() -> new UsernameNotFoundException(username));

        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .authorities(account.getRoles().stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                        .collect(Collectors.toSet())
                )
                .build();
    }

    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
