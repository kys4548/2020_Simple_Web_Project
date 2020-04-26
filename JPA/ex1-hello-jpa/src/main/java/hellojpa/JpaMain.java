package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = em.find(Member.class, 5L);
//            em.persist(member);

//            Member member = new Member();
//            member.setId(100L);
//
//            //1차 캐시 생성, 쓰기 지연 sql -> insert 쿼리
//            em.persist(member);
//            //1차 캐시 변경, 쓰기 지연 sql -> update 쿼리
//            member.setName("youngsil");
//
//            //1차 캐시에 값이 있다면 조회해서 값을 가져옴
//            //없다면 DB에 바로 접근하여 select 쿼리
//            Member member1 = em.find(Member.class, 100L);
//
//            System.out.println(member == member1);
//
//            //영속성 컨텍스트(캐시, 쓰기 지연 sql 저장소)에서
//            //해당 Entity 관련 정보를 다 삭제
//            em.detach(member);


//            Member member = new Member();
//            member.setId(5L);
//            member.setName("HelloB");
//            em.persist(member);
//
//            member.setName("hi");
//            Member member = em.find(Member.class, 1L);
//            em.remove(member);
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member m : result) {
//                System.out.println("member.name = " + m.getName());
//            }
//            Member member = em.find(Member.class, 1L);
//
//            // 쓰지 지연 저장소에 delete 쿼리
//            em.remove(member);
//            System.out.println("member.getName() = " + member.getName());

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
