package com.stu.sd.service;


import com.stu.sd.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findHint();

    void save(Order order);

}
