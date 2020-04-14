package com.example.springdata05.post;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost == post);

        Post post1 = new Post();
        post1.setId(1l);
        post1.setTitle("hibernate");
        Post savedPost1 = postRepository.save(post1);

        assertThat(entityManager.contains(post1)).isFalse();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost1 != post1);

        savedPost1.setTitle("so o rmmmmmm");
        post1.setTitle("change");


        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle() {
        savePost();

        List<Post> all = postRepository.findByTitle("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring Data Jpa");
        return postRepository.save(post);
    }

    @Test
    public void updateTitle() {
        Post spring = savePost();
        spring.setTitle("hibernate");
        List<Post> all = postRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo("hibernate");

//        int update = postRepository.updateTitle("hibernate", spring.getId());
//        assertThat(update).isEqualTo(1);
//
//        Optional<Post> byId = postRepository.findById(spring.getId());
//        assertThat(byId.get().getTitle()).isEqualTo("hibernate");
    }
}