package com.youngsil.springbootmongo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void findByEmail() {
        final Account account = new Account();
        account.setUsername("gessfse");
        account.setEmail("aaa");

        final Account saved = accountRepository.save(account);

        final Optional<Account> byId = accountRepository.findById(saved.getId());
        final Optional byEmail = accountRepository.findByEmail(saved.getEmail());
    }
}