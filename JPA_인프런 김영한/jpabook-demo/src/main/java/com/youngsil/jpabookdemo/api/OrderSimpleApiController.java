package com.youngsil.jpabookdemo.api;

import com.youngsil.jpabookdemo.domain.Order;
import com.youngsil.jpabookdemo.repository.OrderSearch;
import com.youngsil.jpabookdemo.repository.order.simpleQuery.OrderSimpleQueryDto;
import com.youngsil.jpabookdemo.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderService orderService;

    @GetMapping("/api/v1/simple-orders")
    public Result ordersV1() {
        return new Result(orderService.findOrders(new OrderSearch()));
    }
    @GetMapping("/api/v2/simple-orders")
    public Result ordersV2() {
        final List<Order> orders = orderService.findOrders(new OrderSearch());
        final List<OrderSimpleQueryDto> collect = orders.stream()
                .map(o -> new OrderSimpleQueryDto(o))
                .collect(Collectors.toList());
        return new Result(collect);
    }
    @GetMapping("/api/v3/simple-orders")
    public Result ordersV3() {
        List<Order> orders = orderService.findAllWithMemberDelivery();
        final List<OrderSimpleQueryDto> collect = orders.stream()
                .map(o -> new OrderSimpleQueryDto(o))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        T data;
    }
}
