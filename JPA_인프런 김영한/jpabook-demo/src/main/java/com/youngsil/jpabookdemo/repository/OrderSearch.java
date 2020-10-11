package com.youngsil.jpabookdemo.repository;

import com.youngsil.jpabookdemo.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
