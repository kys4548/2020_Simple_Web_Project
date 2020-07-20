package com.youngsil.springbootwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> findById(@PathVariable("bookId") Long bookId) {
        final Book book = bookService.findById(bookId).orElseThrow(RuntimeException::new);
        return ResponseEntity.ok(book);
    }
}
