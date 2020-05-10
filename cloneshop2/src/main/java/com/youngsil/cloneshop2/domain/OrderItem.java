package com.youngsil.cloneshop2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngsil.cloneshop2.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice; //주문 가격
    private int count; //주문 수량

    //생성자
    protected OrderItem(Item item, int count) {
        this.item = item;
        this.count = count;
        this.orderPrice = item.getPrice() * count;
    }

    //연관 관계 편의 메서드
    public void setOrder(Order order) {
        this.order = order;
        order.getOrderItems().add(this);
    }

    public static OrderItem createOrderItem(Item item, int count) {
        item.removeStock(count);
        return new OrderItem(item, count);
    }

    public void cancel() {
        item.addStock(count);
    }
}