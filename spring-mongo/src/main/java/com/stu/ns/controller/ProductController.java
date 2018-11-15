package com.stu.ns.controller;

import com.stu.ns.domain.Product;
import com.stu.ns.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void init() {
        productService.init(100);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public Product update() {
        return productService.update(null);
    }

    @RequestMapping(value = "/query/{name}", method = RequestMethod.GET)
    public List<Product> findByNameLike(@PathVariable String name) {
        return productService.findByNameLike(name);
    }

}
