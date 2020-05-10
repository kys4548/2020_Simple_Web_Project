package com.youngsil.cloneshop2.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDto() {
        return em.createQuery("select new com.youngsil.cloneshop2.repository.order.simplequery.OrderSimpleQueryDto(m.name, o.orderDate, o.status, d.address) " +
                " from Order o" +
                " join fetch o.member m" +
                " join fetch o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
    }
}
