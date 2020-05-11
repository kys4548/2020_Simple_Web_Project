package com.youngsil.cloneshop2.api.controller;

import com.youngsil.cloneshop2.api.lookup.Result;
import com.youngsil.cloneshop2.api.orderdto.OrderDto;
import com.youngsil.cloneshop2.domain.Order;
import com.youngsil.cloneshop2.domain.OrderItem;
import com.youngsil.cloneshop2.repository.OrderRepository;
import com.youngsil.cloneshop2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;

    /**
     *  entity를 통한 조회
     *
     *  Order 전체 조회 1번 쿼리 (n개 조회)
     *
     *  Member 조회  n번 쿼리
     *  Delivery 조회 n번 쿼리
     *
     *
     *  orderItem 조회 n번 쿼리
     */
    @GetMapping("/api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> orders = orderRepository.findAll();
        orders.forEach(o -> {
            o.getMember().getName();
            o.getDelivery().getAddress();
            List<OrderItem> orderItems = o.getOrderItems();
            orderItems.forEach(oi -> oi.getItem().getName());
        });
        return orders;
    }

    /**
     * dto를 통한 조회 entity를 숨길 수 있다.
     *
     * 쿼리 횟수는 v1과 동일하다.
     */
    @GetMapping("/api/v2/orders")
    public List<OrderDto> ordersV2() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/v3/orders")
    public Result<List> orderV3() {
        List<Order> orders = orderRepository.findAllWithItem();
        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @GetMapping("/api/v3.1/orders")
    public Result<List> orderV3_1() {
        List<Order> orders = orderRepository.findAllWithMemberDelivery();

        List<OrderDto> collect = orders.stream()
                .map(o -> new OrderDto(o))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }
}
