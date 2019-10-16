package com.stu.sd;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@ActiveProfiles("sharding-standard")
@Ignore
public class KeyGeneratorApplicationTests {

    @Test
    public void contextLoads() {
        DefaultKeyGenerator keyGenerator = new DefaultKeyGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(keyGenerator.generateKey());
        }
    }

}

