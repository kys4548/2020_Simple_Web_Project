package hellojpa;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;


    //Period
    @Embedded
    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    //주소
//    @Embedded
//    @AttributeOverrides({
//    })
//    private Address workAddress;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void ChangeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
