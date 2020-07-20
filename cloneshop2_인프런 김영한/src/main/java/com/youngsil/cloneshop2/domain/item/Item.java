package com.youngsil.cloneshop2.domain.item;

import com.youngsil.cloneshop2.domain.ItemCategory;
import com.youngsil.cloneshop2.exception.NotEnoughStockException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    List<ItemCategory> itemCategories;

    //생성자
    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void removeStock(int count) {
        int restStock = stockQuantity - count;
        if(restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.");
        }
        stockQuantity = restStock;
    }

    public void addStock(int count) {
        stockQuantity += count;
    }
}
