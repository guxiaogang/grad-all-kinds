package com.stu.sd.repository;



import com.stu.sd.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findByUserId(long userId);

    List<Order> findByUserIdIn(long...userIds);

    List<Order> findByUserIdLessThan(long userId);
}
