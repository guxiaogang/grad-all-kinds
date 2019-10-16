package com.stu.sd;


import com.stu.sd.model.ItemGenerator;
import com.stu.sd.model.Order;
import com.stu.sd.model.OrderGenerator;
import com.stu.sd.model.OrderItem;
import com.stu.sd.service.OrderService;
import com.stu.sd.service.ProvinceService;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@ActiveProfiles("sharding-standard")
@Ignore
public class ShardingStandardTests {

    @Autowired
    OrderService orderService;

    @Autowired
    ProvinceService provinceService;

    @Test
    public void contextLoads() {
        DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
        long userId= keyGenerator.generateKey().longValue();
        long orderId= keyGenerator.generateKey().longValue();
        Order order = OrderGenerator.generate();
        order.setUserId(userId);
        order.setId(orderId);
        OrderItem orderItem = ItemGenerator.generate();
        order.addOrderItem(orderItem);
        orderService.save(order);

        System.out.println(orderService.findByUserId(userId));
        System.out.println(orderService.findById(orderId));

        userId= keyGenerator.generateKey().longValue();
        orderId= keyGenerator.generateKey().longValue();
        order = OrderGenerator.generate();
        order.setUserId(userId);
        order.setId(orderId);
        orderItem = ItemGenerator.generate();
        order.addOrderItem(orderItem);
        orderService.save(order);

        System.out.println(orderService.findByUserId(userId));
        System.out.println(orderService.findById(orderId));

    }

    @Test
    public void testIn(){
//        Order order = OrderGenerator.generate();
//        order.setUserId(2l);
//        order.setId(5l);
//        orderService.save(order);

//        order = OrderGenerator.generate();
//        order.setUserId(3l);
//        order.setId(4l);
//        orderService.save(order);
        System.out.println(orderService.findByUserIds(2l,3l));
    }

    @Test
    public void testRange(){
        System.out.println(orderService.findByUserIdLessThan(3l));
    }
}

