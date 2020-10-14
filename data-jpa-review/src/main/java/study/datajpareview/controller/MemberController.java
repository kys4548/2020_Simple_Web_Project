package study.datajpareview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpareview.entity.Member;
import study.datajpareview.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member =memberRepository.findById(id).get();
        return member.getUsername();
    }

    @GetMapping("/members")
    public Page<Member> list(@PageableDefault() Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}
