package com.example.exceptionintransactiondemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionalInnerService {

    private final PostRepository postRepository;

    public void innerMethodThrowingRuntimeEx() {
        postRepository.save(new Post("[test]"));
        throw new RuntimeException("RuntimeException inside");
    }
}
