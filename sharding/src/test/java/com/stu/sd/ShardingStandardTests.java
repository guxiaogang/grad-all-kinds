package com.stu.sd;


import com.stu.sd.model.ItemGenerator;
import com.stu.sd.model.Order;
import com.stu.sd.model.OrderGenerator;
import com.stu.sd.model.OrderItem;
import com.stu.sd.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class ShardingStandardTests {

    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() {
        Order order = OrderGenerator.generate();
        order.setUserId(10000000l);
        order.setId(1000000l);
        OrderItem orderItem = ItemGenerator.generate();
        order.addOrderItem(orderItem);
        orderService.save(order);

        order = OrderGenerator.generate();
        order.setUserId(10000001l);
        order.setId(1000001l);
        orderItem = ItemGenerator.generate();
        order.addOrderItem(orderItem);
        orderService.save(order);
    }
}

