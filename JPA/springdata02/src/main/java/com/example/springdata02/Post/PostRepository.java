package com.example.springdata02.Post;

import com.example.springdata02.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository<Post>{

}
