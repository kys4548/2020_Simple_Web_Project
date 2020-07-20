//package me.youngsil;
//
//import org.hibernate.Session;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//@Component
//@Transactional
//public class JpaRunner implements ApplicationRunner {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
////        Post post = new Post();
////        Comment comment = new Comment();
////        Comment comment1 = new Comment();
////
////        post.setTitle("spring post");
////        comment.setComment("hi");
////        comment1.setComment("bye");
////
////        post.getComments().add(comment);
////        post.getComments().add(comment1);
////        comment.setPost(post);
////        comment1.setPost(post);
//
//        Session session = entityManager.unwrap(Session.class);
//
////        session.save(post);
//        Post post = session.get(Post.class, 1l);
//        System.out.println("post에서 출력");
//        System.out.println(post.getTitle());
//
//        post.getComments().forEach(c -> {
//            System.out.println("===============");
//            System.out.println(c.getComment());
//        });
//
//        Comment comment = session.get(Comment.class, 3l);
//        System.out.println("comment에서 출력");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());
//
//
////        Account account = new Account();
////        account.setUsername("youngsil");
////        account.setPassword("cj4548");
////
////        Study study = new Study();
////        study.setName("spring data jpa");
////
////
////        study.setOwner(account);
////        account.getStudies().add(study);
////
////        Session session = entityManager.unwrap(Session.class);
////        session.save(account);
////        session.save(study);
////
////        Account a = session.load(Account.class, account.getId());
////        a.setUsername("kim");
////        a.setUsername("kim");
////        a.setUsername("kim");
////        a.setUsername("kim");
////        a.setUsername("youngsil");
////        System.out.println("================================");
////        System.out.println(a.getUsername());
//
//
//     }
//}
