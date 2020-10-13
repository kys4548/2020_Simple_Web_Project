package study.datajpareview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpareview.entity.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
        final Member member = new Member("memberA");
        final Member savedMember = memberJpaRepository.save(member);
        final Member findMember = memberJpaRepository.find(savedMember.getId());
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void basicCRUD() {
        final Member member1 = new Member("member1");
        final Member member2 = new Member("member2");

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        final Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        final Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        final List<Member> all = memberJpaRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        final long count = memberJpaRepository.count();
        assertThat(count).isEqualTo(2);

        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        final long deleteCount = memberJpaRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThen() {
        final Member member1 = new Member("member1", 10);
        final Member member2 = new Member("member2", 20);

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        final List<Member> members = memberJpaRepository.findByUsernameAndAgeGreaterThen("member1", 5);
        assertThat(members.size()).isEqualTo(1);
    }

    @Test
    void paging() throws Exception {
        //given

        int age = 10;
        int offset = 0;
        int limit = 3;

        //when
        final List<Member> members = memberJpaRepository.findByPage(age, offset, limit);
        long totalCount = memberJpaRepository.totalCount(age);
        //then
    }
}