package com.example.exceptionintransactiondemo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OuterService {
    private final TransactionalInnerService transactionalInnerService;

    public void callingTransactionalMethodThrowingRuntimeEx() {
        try {
            transactionalInnerService.innerMethodThrowingRuntimeEx();
        } catch (RuntimeException ex) {
            log.warn("OuterService caught exception at outer. ex: {}", ex.getMessage());
        }
    }
}
