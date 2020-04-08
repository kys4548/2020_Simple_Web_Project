package com.example.springdata04;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

//main에서 우리가 구현한 base class를 알려줘야한다.
public class MyRepository2Impl<T, ID extends Serializable>  extends SimpleJpaRepository<T, ID> implements MyRepository2<T, ID> {

    private EntityManager entityManager;

    public MyRepository2Impl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
