package com.youngsil.cloneshop2.api.orderdto;

import com.youngsil.cloneshop2.domain.Address;
import com.youngsil.cloneshop2.domain.Order;
import com.youngsil.cloneshop2.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SimpleOrderDto {
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public SimpleOrderDto(Order order) {
        name = order.getMember().getName();
        orderDate = order.getOrderDate();
        orderStatus = order.getStatus();
        address = order.getDelivery().getAddress();
    }
}
