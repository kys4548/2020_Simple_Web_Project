package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member();
            em.persist(member);
            member.setName("youngsil");

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember = " + findMember.getName());

            Order order = new Order();
            em.persist(order);

            em.flush();
            em.clear();

            Order findOrder = em.find(Order.class, 2L);
            System.out.println("findOrder = " + findOrder.getMember().getName());

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
