package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);

            List<Member> resultList = query.getResultList();

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

            TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.id=10", Member.class);
            Member singleResult = query2.getSingleResult();



            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
