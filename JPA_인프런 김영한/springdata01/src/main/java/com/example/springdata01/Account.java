package com.example.springdata01;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    //제약조건 넣기
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    //날짜정보를 자동으로 입력
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    //객체에는 있지만 DB에는 없는 정보
    @Transient
    private String noDB;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    //account가 여러개의 study를 관리한다.
    @OneToMany(mappedBy = "owner")
    private Set<Study> studySet = new HashSet<Study>();














    public Long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Study> getStudySet() {
        return studySet;
    }

    public void setStudySet(Set<Study> studySet) {
        this.studySet = studySet;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getNoDB() {
        return noDB;
    }

    public void setNoDB(String noDB) {
        this.noDB = noDB;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudy(Study study) {
        this.getStudySet().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudySet().remove(study);
        study.setOwner(null);
    }
}
