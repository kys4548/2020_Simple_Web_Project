package com.example.springdata05.Comment;

import com.example.springdata05.post.Post;
import com.example.springdata05.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getUpDown() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        Comment savedComment = commentRepository.save(comment);
        commentRepository.findByPost_Id(savedPost.getId(), CommentSummary.class).forEach(c -> {
            System.out.println(c.getVotes());
        });
    }

    @Test
    public void fetchAndLoad() {
        commentRepository.getById(1l);
        commentRepository.findById(1l);
    }

    @Test
    public void getComment() {
//        Post post = new Post();
//        post.setTitle("jpa");
//        Post savePost = postRepository.save(post);
//
//        Comment comment = new Comment();
//        comment.setComment("comment");
//        comment.setPost(savePost);
//        Comment saveComment = commentRepository.save(comment);


        Optional<Comment> byId = commentRepository.findById(2l);
//        Post getPost = byId.get().getPost();
//        Post getPost = all.get(0).getPost();
//        assertThat(getPost.getTitle()).isEqualTo("jpa");
    }
}