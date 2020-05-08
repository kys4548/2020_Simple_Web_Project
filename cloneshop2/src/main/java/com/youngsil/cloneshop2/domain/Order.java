package com.youngsil.cloneshop2.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //생성자
    protected Order(Member member, Delivery delivery, OrderItem... orderItems) {
        setMember(member);
        this.delivery = delivery;
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(this);
        }
        orderDate = LocalDateTime.now();
        status = OrderStatus.ORDER;
    }

    //연관 관계 편의 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        return new Order(member, delivery, orderItems);
    }

}
