package com.stu.ns.repo;

import com.stu.ns.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Override
    void delete(Product deleted);

    @Query(value = "{'prodName' : {'$regex' : ?0},'type':'A'}", fields = "{'id':1, 'prodName' : 1}")
    List<Product> findByName(String productName);
}
