package com.youngsil.jpabookdemo.api;

import com.youngsil.jpabookdemo.domain.Order;
import com.youngsil.jpabookdemo.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;

}
