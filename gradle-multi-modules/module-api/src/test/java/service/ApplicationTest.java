package service;

import meber.Member;
import meber.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTest {

    @Autowired
    MemberServiceCustom memberServiceCustom;

    @Test
    public void test01() {
        final Member member = new Member("test01", "test.com");
        memberServiceCustom.signup(member);
    }


}