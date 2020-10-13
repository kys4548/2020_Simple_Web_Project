package com.youngsil.jpabookdemo.repository.order.simpleQuery;

import com.youngsil.jpabookdemo.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderSimpleQueryRepository {

    @PersistenceContext
    EntityManager em;

}
