package com.example.springdata02.Post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findMyPost();

    void delete(T entity);
}
