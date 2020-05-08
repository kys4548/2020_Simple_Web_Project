package com.youngsil.cloneshop2.service;

import com.youngsil.cloneshop2.domain.*;
import com.youngsil.cloneshop2.domain.item.Item;
import com.youngsil.cloneshop2.repository.ItemRepository;
import com.youngsil.cloneshop2.repository.MemberRepository;
import com.youngsil.cloneshop2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Item item = itemRepository.findOne(itemId);

        OrderItem orderItem = OrderItem.createOrderItem(item, count);
        Member member = memberRepository.findOne(memberId);

        Delivery delivery = new Delivery(member.getAddress());

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

}
