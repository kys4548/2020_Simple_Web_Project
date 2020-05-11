package com.youngsil.cloneshop2.repository.order.simplequery;

import com.youngsil.cloneshop2.domain.Address;
import com.youngsil.cloneshop2.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderSimpleQueryDto {
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

}
