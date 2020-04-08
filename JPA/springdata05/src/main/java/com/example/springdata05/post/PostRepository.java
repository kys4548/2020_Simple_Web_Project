package com.example.springdata05.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PostRepository extends JpaRepository<Post, Long> {

}
