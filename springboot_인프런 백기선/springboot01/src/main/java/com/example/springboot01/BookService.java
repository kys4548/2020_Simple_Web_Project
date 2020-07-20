package com.example.springboot01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepositoryList;

    public void printBookRepository() {
        this.bookRepositoryList.forEach(System.out::println);
    }

    @PostConstruct
    public void setUp() {

    }
}
