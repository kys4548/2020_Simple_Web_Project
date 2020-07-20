package com.youngsil.cloneshop2.repository;

import com.youngsil.cloneshop2.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

//DTO
@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
