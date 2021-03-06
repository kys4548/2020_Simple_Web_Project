package com.youngsil.cloneshop.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("b")
@Getter
public class Book extends Item {

    private String author;
    private String isbn;
}
