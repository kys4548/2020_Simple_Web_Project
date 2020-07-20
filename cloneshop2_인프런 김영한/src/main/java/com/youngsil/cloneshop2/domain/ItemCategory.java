package com.youngsil.cloneshop2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngsil.cloneshop2.domain.item.Item;

import javax.persistence.*;

@Entity
public class ItemCategory {

    @Id @GeneratedValue
    @Column(name = "item_category_id")
    private Long id;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    //연관 관계 편의 메서드
    public void setItem(Item item) {
        this.item = item;
        item.getItemCategories().add(this);
    }
}
