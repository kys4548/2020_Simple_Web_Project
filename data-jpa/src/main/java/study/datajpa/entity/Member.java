package study.datajpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * entity는 기본생성자를 필수로 가지고 있어야 한다.
 *
 * access 레벨은 private가 아닌 protected를 사용해야 한다.
 * jpa에서 프록시 같은 기술을 사용하는데 private로 하면 에러 발생.
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;


    //생성자
    public static Member createMember(String username) {
        Member member = new Member();
        member.username = username;

        return member;
    }

    //Setter
    public void changeUsername(String username) {
        this.username = username;
    }

}
