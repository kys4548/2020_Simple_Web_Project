package com.youngsil.springbootwebservice;

import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);
}
