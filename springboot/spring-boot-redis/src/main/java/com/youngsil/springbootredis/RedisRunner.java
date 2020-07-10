package com.youngsil.springbootredis;

import com.youngsil.springbootredis.account.Account;
import com.youngsil.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final Account account = new Account();
        account.setUsername("youngsil");
        account.setEmail("kys4548@naver.com");
        final Account savedAccount = accountRepository.save(account);

        final Optional<Account> byId = accountRepository.findById(savedAccount.getId());
        System.out.println(byId.get().getUsername());
        System.out.println(byId.get().getEmail());

        final Account account1 = new Account();
        account1.setUsername("jiwon");
        account1.setEmail("jiwon@love.com");
        accountRepository.save(account1);
    }
}