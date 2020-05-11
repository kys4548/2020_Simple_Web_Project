package com.youngsil.cloneshop2.api.orderdto;

import com.youngsil.cloneshop2.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OrderItemDto {

    private String itemName;
    private int orderPrice;
    private int count;

    public OrderItemDto(OrderItem orderItem) {
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getOrderPrice();
        count = orderItem.getCount();
    }
}
