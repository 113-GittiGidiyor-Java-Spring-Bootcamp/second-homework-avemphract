package dev.patika.secondhomework.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    T deleteById(int id);
}
