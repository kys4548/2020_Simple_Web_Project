package com.example.springboot04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

public class BookFormatter implements Formatter<Book> {

    @Override
    public Book parse(String s, Locale locale) throws ParseException {
        return new Book(Integer.parseInt(s));
    }

    @Override
    public String print(Book book, Locale locale) {
        return book.getId().toString();
    }
}
