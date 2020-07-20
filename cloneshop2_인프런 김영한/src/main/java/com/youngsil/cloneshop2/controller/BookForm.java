package com.youngsil.cloneshop2.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
public class BookForm {

    private String name;

    private int price;
    private int stockQuantity;

    private String author;
    private String isbn;

    public BookForm() {

    }

    public BookForm(String name, int price, int stockQuantity, String author, String isbn) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.author = author;
        this.isbn = isbn;
    }
}
