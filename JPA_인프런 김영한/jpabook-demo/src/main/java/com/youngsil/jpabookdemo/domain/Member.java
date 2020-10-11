package com.youngsil.jpabookdemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy ="member")
    private List<Order> orders = new ArrayList<>();
}
