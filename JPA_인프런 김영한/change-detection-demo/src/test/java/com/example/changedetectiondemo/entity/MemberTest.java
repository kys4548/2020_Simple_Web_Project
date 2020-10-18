package com.example.changedetectiondemo.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void memberTest() throws Exception {
        final Member member = new Member("youngsil", 27);
        em.persist(member);

        member.setUsername("kimyoungsil");

        em.flush();
    }
}