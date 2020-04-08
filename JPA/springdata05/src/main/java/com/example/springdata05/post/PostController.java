package com.example.springdata05.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

//    public PostRepository postRepository(PostRepository postRepository) {
//        return this.postRepository = postRepository;
//    }


    //스프링 데이터의 DomainClassConverter에 의해
    //id만으로 entity얻기 가능 entity -> id 또한 가능
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }


//    @GetMapping("/posts/{id}")
//    public String getPost(@PathVariable Long id) {
//        Optional<Post> byId = postRepository.findById(id);
//        Post post = byId.get();
//        return post.getTitle();
//    }


    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

}
