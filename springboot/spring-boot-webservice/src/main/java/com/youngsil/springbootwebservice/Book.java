package com.youngsil.springbootwebservice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book extends AbstractPersistable<Long> {

    private String name;
    private String isbn13;
    private String isbn10;

    @Builder
    public Book(String name, String isbn13, String isbn10) {
        this.name = name;
        this.isbn10 = isbn10;
        this.isbn13 =isbn13;
    }
}
