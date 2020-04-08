package com.example.springdata04.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<Post> findByPost();

    //JpaRepository와 중복된 메소드 덮어쓰기 가능
   void delete(T entity);
}
