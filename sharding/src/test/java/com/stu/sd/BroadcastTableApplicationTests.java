package com.stu.sd;


import com.stu.sd.model.Province;
import com.stu.sd.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
@ActiveProfiles("sharding-standard")
public class BroadcastTableApplicationTests {
    @Autowired
    private ProvinceService provinceService;

    @Test
    public void test() {
        Province pro = new Province();
        pro.setId(222);
        pro.setName("上海");
        provinceService.save(pro);
    }
}
