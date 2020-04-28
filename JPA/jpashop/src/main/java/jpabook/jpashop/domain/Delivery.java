package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private DelivertStatus status;
    private String city;
    private String street;
    private String zipCode;

    @OneToOne(mappedBy ="delivery")
    private Order order;
}
