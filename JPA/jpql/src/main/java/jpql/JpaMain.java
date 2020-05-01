package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Team team3 = new Team();
            team3.setName("teamC");
            em.persist(team3);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.changeTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.changeTeam(team1);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.changeTeam(team2);
            em.persist(member3);

            Member member4 = new Member();
            member4.setUsername("member4");
            em.persist(member4);

//            em.flush();
//            em.clear();

            //벌크 연산전에 flush가 일어난다.

            int count = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            Team team = em.find(Team.class, team1.getId());
            List<Member> members = team.getMembers();
            for (Member member : members) {
                System.out.println("member = " + member.getAge());
            }

            em.clear();

            Team team4 = em.find(Team.class, team1.getId());
            List<Member> members1 = team4.getMembers();
            for (Member member : members1) {
                System.out.println("member = " + member.getAge());
            }
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
