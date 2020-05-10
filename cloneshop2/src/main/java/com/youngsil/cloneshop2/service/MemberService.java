package com.youngsil.cloneshop2.service;

import com.youngsil.cloneshop2.domain.Address;
import com.youngsil.cloneshop2.domain.Member;
import com.youngsil.cloneshop2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long memberId, String name) {
        Member member = memberRepository.findOne(memberId);
        member.changeName(name);
    }

    @Transactional
    public void update(Long memberId, String name, String city, String street, String zipcode) {
        Member member = memberRepository.findOne(memberId);
        member.changeName(name);
        member.changeAddress(new Address(city, street, zipcode));
    }
}
