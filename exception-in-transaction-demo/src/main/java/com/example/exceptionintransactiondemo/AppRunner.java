package com.example.exceptionintransactiondemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final OuterService outerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        outerService.callingTransactionalMethodThrowingRuntimeEx();
    }
}
