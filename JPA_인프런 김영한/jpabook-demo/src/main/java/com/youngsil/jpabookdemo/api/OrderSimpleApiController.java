package com.youngsil.jpabookdemo.api;

import com.youngsil.jpabookdemo.domain.Order;
import com.youngsil.jpabookdemo.repository.OrderRepository;
import com.youngsil.jpabookdemo.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
        return all;
    }


}
