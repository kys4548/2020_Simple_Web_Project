package com.youngsil.jpabookdemo;

import com.youngsil.jpabookdemo.domain.Address;
import com.youngsil.jpabookdemo.domain.Member;
import com.youngsil.jpabookdemo.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

/**
 * InitDB CLASS에 메서드를 두어도 될것 같지만
 * Transactional이 적용되지 않아서 inner class 사용
 */

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void dbInit1() {
            Member member = new Member();
            member.setName("userA");
            member.setAddress(new Address("1","2","3"));
            em.persist(member);

            Book book1 = new Book();
        }
    }
}
