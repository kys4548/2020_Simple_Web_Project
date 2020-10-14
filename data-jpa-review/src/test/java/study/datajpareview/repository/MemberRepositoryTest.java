package study.datajpareview.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import study.datajpareview.entity.Member;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        System.out.println(memberRepository.getClass());
        final Member member = new Member("memberA");
        final Member savedMember = memberRepository.save(member);
        final Member findMember = memberRepository.findById(savedMember.getId()).get();

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void basicCRUD() {
        final Member member1 = new Member("member1");
        final Member member2 = new Member("member2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        final Member findMember1 = memberRepository.findById(member1.getId()).get();
        final Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        final List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        final long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        memberRepository.delete(member1);
        memberRepository.delete(member2);

        final long deleteCount = memberRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreaterThen() {
        final Member member1 = new Member("member1", 10);
        final Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        final List<Member> members = memberRepository.findByUsernameAndAgeGreaterThan("member1", 5);
        assertThat(members.size()).isEqualTo(1);
    }

    @Test
    public void dtoTest() {
        memberRepository.findMemberDto();
    }

    @Test
    public void listBindingTest() {
        memberRepository.findByNames(Arrays.asList("AAA","BBB"));
    }

    @Test
    void pageable() throws Exception {
        //given
        int age = 10;
        final PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));


        //when
        final Page<Member> page = memberRepository.findByAge(age, pageRequest);
        //then
        final List<Member> content = page.getContent();
        page.getTotalElements();
        System.out.println(page);
    }

    @Test
    public void callCustom() {

    }
}