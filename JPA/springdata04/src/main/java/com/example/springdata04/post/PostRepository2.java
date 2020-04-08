package com.example.springdata04.post;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//사용자가 원하는 기능만 가진 Repository
@RepositoryDefinition(domainClass = Post.class, idClass = Long.class)
public interface PostRepository2 {

    Post save(Post post);

    List<Post> findAll();
}
