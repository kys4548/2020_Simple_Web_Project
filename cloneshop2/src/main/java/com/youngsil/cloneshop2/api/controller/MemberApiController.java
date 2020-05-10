package com.youngsil.cloneshop2.api.controller;

import com.youngsil.cloneshop2.api.lookup.Result;
import com.youngsil.cloneshop2.api.memberdto.*;
import com.youngsil.cloneshop2.domain.Member;
import com.youngsil.cloneshop2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 생성
     */
    @PostMapping("api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest createMemberRequest) {
        Member member = new Member(createMemberRequest.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    /**
     *  업데이트
     */

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMmeberV1(@PathVariable("id") Long memberId,
                                               @RequestBody @Valid UpdateMemberRequest updateMemberRequest) {
        memberService.update(memberId, updateMemberRequest.getName(), updateMemberRequest.getCity(), updateMemberRequest.getStreet(), updateMemberRequest.getZipcode());
        Member member = memberService.findOne(memberId);
        return new UpdateMemberResponse(member.getName(), member.getAddress());
    }

    /**
     * 조회
     */
    @GetMapping("/api/v1/members")
    public List<Member> memberV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result memberV2() {
        List<Member> members = memberService.findMembers();
        List<LookupMember> collect = members.stream()
                .map(m -> new LookupMember(m.getName(), m.getAddress()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }
}
