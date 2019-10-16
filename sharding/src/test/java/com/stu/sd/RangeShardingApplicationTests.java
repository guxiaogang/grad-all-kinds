package com.stu.sd;

import com.stu.sd.model.ItemGenerator;
import com.stu.sd.model.Order;
import com.stu.sd.model.OrderGenerator;
import com.stu.sd.model.OrderItem;
import com.stu.sd.service.OrderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@ActiveProfiles("sharding-range")
@Ignore
public class RangeShardingApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        Order order = OrderGenerator.generate();
        order.setUserId(10000002l);
        order.setId(1000002l);
        OrderItem orderItem = ItemGenerator.generate();
        orderItem.setUserId(order.getUserId());
        order.addOrderItem(orderItem);
        orderService.save(order);
    }
}
