package com.stu.ns.service.impl;

import com.stu.ns.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    public void save(T t) {
        mongoTemplate.save(t);
    }

    @Override
    public void saveObject(Object object) {
        mongoTemplate.save(object);
    }

    @Override
    public void delete(T t) {
        mongoTemplate.remove(t);
    }

    @Override
    public T findById(ID id, Class<T> clazz) {
        return mongoTemplate.findById(id, clazz);
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(getTypeClass());
    }

    private Class<T> getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
