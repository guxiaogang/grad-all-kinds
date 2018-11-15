package com.stu.ns.service;

import com.stu.ns.domain.Product;

import java.util.List;

public interface ProductService {

    void init(int count);

    Product update(Product product);

    List<Product> findByNameLike(String name);
}
