package com.youngsil.cloneshop.domain;

import com.youngsil.cloneshop.domain.item.Item;
import lombok.Getter;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<ItemCategory> itemCategoryList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child;


    //== 연관관계 편의 메서드 ==//
    /**
     * parent and child
     */
    public void setParentCategoryBoth(Category parent) {
        parent.getChild().add(parent);
        this.parent = parent;
    }
}
