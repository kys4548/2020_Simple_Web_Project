package com.youngsil.cloneshop2.repository.order.simplequery;

import com.youngsil.cloneshop2.domain.Address;
import com.youngsil.cloneshop2.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto {
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address;
    }
}
