package com.stu.ns.service.impl;

import com.stu.ns.domain.Product;
import com.stu.ns.repo.ProductRepository;
import com.stu.ns.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void init(int count) {
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setId(i + "");
            product.setProdName("Product Name" + i);
            product.setProdPrice(Double.valueOf(i));
            product.setProdDesc("This " + i + "is desc.");
            productRepository.save(product);
        }
    }

    @Override
    public Product update(Product product) {
        Product productOld = productRepository.findById(1 + "").get();
        productOld.setProdName("updated");
        productRepository.save(productOld);
        return productOld;
    }

    @Override
    public List<Product> findByNameLike(String name) {
        return productRepository.findByName(name);
    }

}
