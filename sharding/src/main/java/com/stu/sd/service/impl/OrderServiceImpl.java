package com.stu.sd.service.impl;


import com.stu.sd.model.Order;
import com.stu.sd.repository.OrderRepo;
import com.stu.sd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public List<Order> findByUserId(long userId) {
        return orderRepo.findByUserId(userId);
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepo.findById(id);
    }

    @Override
    public List<Order> findByUserIds(long[] userIds) {
        return orderRepo.findByUserIdIn(userIds);
    }

    @Override
    public List<Order> findByUserIdLessThan(long userId) {
        return orderRepo.findByUserIdLessThan(userId);
    }

    @Override
    public List<Order> findHint() {
        return orderRepo.findAll();
    }
}
