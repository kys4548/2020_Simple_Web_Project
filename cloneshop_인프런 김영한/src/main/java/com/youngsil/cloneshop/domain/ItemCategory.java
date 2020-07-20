package com.youngsil.cloneshop.domain;

import com.youngsil.cloneshop.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ItemCategory {

    @Id @GeneratedValue
    @Column(name = "item_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    //== 연관 관계 매핑 메서드 ==//
    /**
     * Item and ItemCategory
     */
    public void setItemBoth(Item item) {
        this.item = item;
        item.getItemCategoryList().add(this);
    }

    /**
     * Category and ItemCategory
     */
    public void setCategoryBoth(Category category) {
        this.category = category;
        category.getItemCategoryList().add(this);
    }
}
