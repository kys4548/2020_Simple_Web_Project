package study.datajpareview.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpareview.repository.MemberJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity() {
        final Team teamA = new Team("teamA");
        final Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        final Member member1 = new Member("member1", 10, teamA);
        final Member member2 = new Member("member2", 10, teamA);
        final Member member3 = new Member("member3", 10, teamB);
        final Member member4 = new Member("member4", 10, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        final List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        for (Member member : members) {
            member.getTeam().getName();
        }

    }

    @Test
    public void lazyTest() {
        final Member member = new Member("member");
        final Team team = new Team("team");
        final Member member2 = new Member("member");
        final Team team2 = new Team("team");

        member.changeTeam(team);
        member2.changeTeam(team2);

        em.persist(member);
        em.persist(team);
        em.persist(member2);
        em.persist(team2);

        em.flush();
        em.clear();

        final Member findMember = em.find(Member.class, member.getId());
        final Member findMember2 = em.find(Member.class, member2.getId());
        System.out.println(findMember2.getTeam().getClass() + " " + findMember.getTeam().getClass());


    }

    @Test
    public void transactionTest() {
        em.persist(new Member("member"));
    }
}