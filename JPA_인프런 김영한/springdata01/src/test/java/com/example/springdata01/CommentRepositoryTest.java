package com.example.springdata01;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() {
        this.createComment(100, "spring data jpa");
        this.createComment(55, "hibernate spring");

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "LikeCount"));
        Page<Comment> spring1 = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        assertThat(spring1.getNumberOfElements()).isEqualTo(2);
        assertThat(spring1).first().hasFieldOrPropertyWithValue("likeCount", 100);


        List<Comment> spring = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
        assertThat(spring.size()).isEqualTo(2);
        assertThat(spring).first().hasFieldOrPropertyWithValue("likeCount", 100);


        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Hello", 10);
        assertThat(comments.size()).isEqualTo(0);




//        List<Comment> all = commentRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commentRepository.count();
//        assertThat(count).isEqualTo(1);
//
//        Optional<Comment> byId = commentRepository.findById(100l);
//        assertThat(byId).isEmpty();
//        Comment comment1 = byId.orElse(new Comment());
    }

    private void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setLikeCount(likeCount);
        newComment.setComment(comment);
        commentRepository.save(newComment);
    }
}