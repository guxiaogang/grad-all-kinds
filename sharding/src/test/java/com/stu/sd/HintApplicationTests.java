package com.stu.sd;

import com.stu.sd.service.OrderService;
import io.shardingsphere.api.HintManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@ActiveProfiles("sharding-hint")
@Ignore
public class HintApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("t_order", 1);
        hintManager.addTableShardingValue("t_order", 1);
        System.out.println(orderService.findHint());
    }
}
