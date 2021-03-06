package dev.patika.secondhomework.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    T deleteById(int id);

}
