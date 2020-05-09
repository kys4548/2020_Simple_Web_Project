package com.youngsil.cloneshop2.domain.item;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("b")
@Getter
public class Book extends Item {

    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity, String author, String isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }

    public void updateItem(String name, int price, int stockQuantity, String author, String isbn) {
        setName(name);
        setPrice(price);
        setStockQuantity(stockQuantity);
        this.author = author;
        this.isbn = isbn;
    }
}
