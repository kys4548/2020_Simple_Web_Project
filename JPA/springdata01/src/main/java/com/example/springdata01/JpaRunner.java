package com.example.springdata01;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("Spring Data JPA 화이팅...");
//
//        Comment comment1 = new Comment();
//        comment1.setComment("빨리 보고 싶어요");
//        post.addComment(comment1);
//
//
//        Comment comment2 = new Comment();
//        comment2.setComment("곧 다 보겠지");
//        post.addComment(comment2);
//
        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

        Post p = session.get(Post.class, 1l);
        p.getComments().forEach(c -> {
            System.out.println(c.getComment());
        });
//        session.delete(p);


//        Comment comment = session.get(Comment.class, 2l);


//        Account account = new Account();
//        account.setUsername("youngsil");
//        account.setPassword("1234");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
//
//        account.addStudy(study);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//        session.save(study);
//
//        Account youngsil = session.load(Account.class, account.getId());
//        youngsil.setUsername("jiwon");
//        youngsil.setUsername("jiwon2");
//        youngsil.setUsername("jiwon3");
//        youngsil.setUsername("jiwon4");
//        youngsil.setUsername("jiwon5");
//        youngsil.setUsername("youngsil");
//        System.out.println(youngsil.getUsername());
    }
}
