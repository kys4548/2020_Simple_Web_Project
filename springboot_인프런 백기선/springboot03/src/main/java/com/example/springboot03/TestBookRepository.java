package com.example.springboot03;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class TestBookRepository implements BookRepository {
}
