package com.stu.ns.service;

import java.util.List;

public interface BaseService<T, ID> {
    void save(T t);

    void saveObject(Object object);

    void delete(T t);

    T findById(ID id, Class<T> clazz);

    List<T> findAll();
}
