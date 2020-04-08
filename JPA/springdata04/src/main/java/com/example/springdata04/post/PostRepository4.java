package com.example.springdata04.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

//기본 Repository기능에 기능을 덧붙이거나 덮어쓰는 한가지 방법
public interface PostRepository4<T, ID extends Serializable> extends JpaRepository<T, ID>, PostCustomRepository<T> {
}
