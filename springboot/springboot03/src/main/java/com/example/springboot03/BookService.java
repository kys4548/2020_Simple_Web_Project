package com.example.springboot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service @Scope("singleton")
public class BookService {

    @Autowired @Qualifier("youngsilBookRepository")
    BookRepository bookRepository;

    @PostConstruct
    public void setup() {
        System.out.println("BookService bean create!");
    }
}
