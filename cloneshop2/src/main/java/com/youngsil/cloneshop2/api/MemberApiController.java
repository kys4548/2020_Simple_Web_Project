package com.youngsil.cloneshop2.api;

import com.youngsil.cloneshop2.api.memberdto.CreateMemberRequest;
import com.youngsil.cloneshop2.api.memberdto.CreateMemberResponse;
import com.youngsil.cloneshop2.domain.Member;
import com.youngsil.cloneshop2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

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
}
