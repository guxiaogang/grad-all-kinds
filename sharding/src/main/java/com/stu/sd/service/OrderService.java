package com.stu.sd.service;


import com.stu.sd.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findHint();

    void save(Order order);

    List<Order> findByUserId(long userId);

    Optional<Order> findById(long id);

    List<Order> findByUserIds(long...userId);
}
