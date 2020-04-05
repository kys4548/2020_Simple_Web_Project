package com.example.springdata01;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long>{

    //메서드 이름을 분석하여 springdata common (jpa)이 쿼리를 만들어 준다.
    List<Comment> findByCommentContains(String keyword);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    //jpql
    @Query("SELECT c FROM Comment AS c")
    List<Comment> jpqlQuery();

    //native
    @Query(value = "SELECT * FROM COMMENT", nativeQuery = true)
    List<Comment> nativeQuery();
}
