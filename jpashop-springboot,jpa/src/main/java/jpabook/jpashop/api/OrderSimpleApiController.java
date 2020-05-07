package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto;
import jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne RelationShip
 * Order
 * Order -> Member
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;
    private final OrderSimpleQueryRepository orderSimpleQueryRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByCriteria(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); //Lazy 강제 초기화
            order.getDelivery().getAddress();
        }
        return all;
    }

    @GetMapping("/api/v2/simple-orders")
    public Result<List<SimpleOrderDto>> ordersV2() {
        List<SimpleOrderDto> orders = orderRepository.findAllByCriteria(new OrderSearch()).stream()
                .map(SimpleOrderDto::new)
                .collect(Collectors.toList());
        return new Result(orders.size(), orders);
    }

    @GetMapping("/api/v3/simple-orders")
    public Result<List<SimpleOrderDto>> ordersV3() {
        List<SimpleOrderDto> orders = orderRepository.findAllWithMemberDelivery().stream()
                .map(o -> new SimpleOrderDto(o))
                .collect(Collectors.toList());
        return new Result(orders.size(), orders);
    }

    @GetMapping("/api/v4/simple-orders")
    public Result<List<OrderSimpleQueryDto>> orderV4() {
        List<OrderSimpleQueryDto> orders = orderSimpleQueryRepository.findOrderDtos();
        return new Result(orders.size(), orders);
    }


    @Data
    public class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            orderId = order.getId();
            name = order.getMember().getName(); //LAZY 초기화
            orderDate = order.getOrderDate();
            orderStatus = order.getStatus();
            address = order.getDelivery().getAddress(); // LAZY 초기화화
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }
}
