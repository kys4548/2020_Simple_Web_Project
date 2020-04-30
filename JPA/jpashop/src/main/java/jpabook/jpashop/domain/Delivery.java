package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private DelivertStatus status;
    private String city;
    private String street;
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY, mappedBy ="delivery")
    private Order order;
}
