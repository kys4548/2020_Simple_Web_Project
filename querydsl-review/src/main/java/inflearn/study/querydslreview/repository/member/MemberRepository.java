package inflearn.study.querydslreview.repository.member;

import inflearn.study.querydslreview.entity.Member;
import inflearn.study.querydslreview.repository.member.query.MemberQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> , MemberQueryRepository {
    List<Member> findByUsername(String username);

}
