package com.example.springdata04;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository1<T, ID extends Serializable> extends Repository<T, ID> {
    <E extends T> E save(E entity);
    <E extends T> List<E> findAll();
}
