package com.youngsil.cloneshop2.api.controller;

import com.youngsil.cloneshop2.api.lookup.Result;
import com.youngsil.cloneshop2.api.orderdto.SimpleOrderDto;
import com.youngsil.cloneshop2.domain.Order;
import com.youngsil.cloneshop2.repository.OrderRepository;
import com.youngsil.cloneshop2.repository.OrderSearch;
import com.youngsil.cloneshop2.repository.order.simplequery.OrderSimpleQueryDto;
import com.youngsil.cloneshop2.repository.order.simplequery.OrderSimpleQueryRepository;
import com.youngsil.cloneshop2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderSimpleController {

   private final OrderService orderService;
   private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    /**
     *  Order 전체 조회 1번 쿼리 (n개 조회)
     *  Member 조회  n번 쿼리
     *  Delivery 조회 n번 쿼리
     */
    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> orders = orderService.findAll();
        orders.forEach(o -> {
            o.getMember().getName();
            o.getDelivery().getAddress();
        });
        return orders;
    }

    /**
     *  entity를 이용한 조회 -> dto를 통한 조회
     *
     *  Order 전체 조회 1번 쿼리 (n개 조회)
     *  Member 조회  n번 쿼리
     *  Delivery 조회 n번 쿼리
     */
    @GetMapping("/api/v2/simple-orders")
    public Result<List> ordersV2() {
        List<SimpleOrderDto> collect = orderService.findAll().stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    /**
     *  dto를 통한 조회
     *
     *  join fetch를 통해 쿼리를 한방에 가져온다.
     *  대신 한번에 조회하는 컬럼이 많아진다.
     *  총 쿼리 1회
     */
    @GetMapping("/api/v3/simple-orders")
    public Result<List> ordersV3() {
        List<SimpleOrderDto> collect = orderService.findAllWithMemberDelivery().stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());
        return new Result(collect.size(), collect);
    }

    @GetMapping("/api/v4/simple-orders")
    public Result<List> ordersV4() {
        List<OrderSimpleQueryDto> orders = orderSimpleQueryRepository.findOrderDto();
        return new Result(orders.size(), orders);
    }

}
