package com.example.springdata05.Account;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountAuditAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        System.out.println("looking for current user");
        return Optional.empty();
    }
}
