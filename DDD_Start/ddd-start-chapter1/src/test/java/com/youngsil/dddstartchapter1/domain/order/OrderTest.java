package com.youngsil.dddstartchapter1.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//테스트마다 의존성을 없애기 위해
//각 테스트마다 Test instance 를 생성하여 메서드 실행행
@SpringBootTest
class OrderTest {

    @Test
    @DisplayName("주문은 상품 주문 리스트를 가진다.")
    void check_order_has_orderLine() throws Exception {
        //given
        Order order = new Order();
        //when
        List<OrderLine> orderLineList = order.getOrderLineList();

        //then
        assertNotNull(orderLineList, () -> "주문을 처음 만들면 상품 주문 리스트를 가져야한다.");
    }
}