package com.youngsil.cloneshop2.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //연관 관계 편의 메서드
    public void setParent(Category parent) {
        this.parent = parent;
        parent.getChild().add(this);
    }
}