package com.stu.sd.service.impl;


import com.stu.sd.model.Order;
import com.stu.sd.repository.OrderRepo;
import com.stu.sd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void save(Order order) {
        orderRepo.save(order);
    }

    @Override
    public List<Order> findHint() {
        return null;
    }
}
