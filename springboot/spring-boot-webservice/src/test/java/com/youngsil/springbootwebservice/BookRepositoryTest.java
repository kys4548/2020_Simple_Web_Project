package com.youngsil.springbootwebservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;


    @Test
    void testSave() {
        final Book book = Book.builder()
                .name("spring-boot-book")
                .isbn10("10")
                .isbn13("13")
                .build();

        assertThat(book.isNew()).isTrue();

        final Book save = bookRepository.save(book);

        assertThat(book.isNew()).isFalse();
    }
}