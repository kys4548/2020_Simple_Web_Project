package com.youngsil.springbootwebservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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

    @Test
    void testFindByNameLike() {
        final Book book = Book.builder()
                .name("spring-boot-book")
                .isbn10("10")
                .isbn13("13")
                .build();

        bookRepository.save(book);

        final List<Book> books = bookRepository.findByNameLike("spring-boot-book");
        assertThat(books).isNotEmpty();
        final List<Book> boo = bookRepository.findByNameLike("boo");
        assertThat(boo).isEmpty();

    }
}