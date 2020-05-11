package com.youngsil.cloneshop2.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Repository를 따로 분리해놓은 이유
 * 해당 Repository에 있는 메서드는 entity를 이용한 db접근이 아니라
 * UI에 최적화 된 Dto를 통해 db접근이 이루어진다.
 *
 * entity를 이용한 db접근과 구분을 편리하게 하기위해 분리.
 * 기본 Repository는 순수한 entity로 접근할 때만 사용하자.
 */
@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDto() {
        return em.createQuery("select new com.youngsil.cloneshop2.repository.order.simplequery.OrderSimpleQueryDto(m.name, o.orderDate, o.status, d.address)" +
                " from Order o" +
                " join o.member m" +
                " join o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
    }
}
