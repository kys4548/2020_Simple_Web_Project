package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private DelivertStatus status;

    @Embedded
    private Address address;

    @OneToOne(fetch = FetchType.LAZY, mappedBy ="delivery")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DelivertStatus getStatus() {
        return status;
    }

    public void setStatus(DelivertStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
