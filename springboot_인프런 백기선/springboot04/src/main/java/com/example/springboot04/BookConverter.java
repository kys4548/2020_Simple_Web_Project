package com.example.springboot04;

import org.springframework.core.convert.converter.Converter;

public class BookConverter {

    public static class StringToEventConverter implements Converter<String, Book> {

        @Override
        public Book convert(String s) {
            return new Book(Integer.parseInt(s));
        }
    }

    public static class EventToStringConverter implements Converter<Book, String> {

        @Override
        public String convert(Book book) {
            return book.getId().toString();
        }
    }
}

