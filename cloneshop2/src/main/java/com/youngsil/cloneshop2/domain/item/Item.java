package com.youngsil.cloneshop2.domain.item;

import com.youngsil.cloneshop2.domain.ItemCategory;
import com.youngsil.cloneshop2.exception.NotEnoughStockException;
import lombok.Getter;

import javax.persistence.*;
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
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<ItemCategory> itemCategories;


    public void removeStock(int count) {
        int restStock = stockQuantity - count;
        if(restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }
        stockQuantity = restStock;
    }
}
