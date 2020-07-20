package com.example.springdata04.post;

import org.springframework.data.jpa.repository.JpaRepository;

//가장 기본적인 Repository
public interface PostRepository1 extends JpaRepository<Post, Long> {

}
