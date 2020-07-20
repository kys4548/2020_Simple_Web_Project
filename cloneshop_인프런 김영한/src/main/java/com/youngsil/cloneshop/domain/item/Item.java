package com.youngsil.cloneshop.domain.item;

import com.youngsil.cloneshop.domain.ItemCategory;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    private List<ItemCategory> itemCategoryList = new ArrayList<>();

    private int price;
    private int stockQuantity;


    //== 비지니스 로직 ==//
    public void addStock(int quantity) {
        stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = stockQuantity - quantity;
        if(restStock < 0) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        stockQuantity = restStock;
    }
}
