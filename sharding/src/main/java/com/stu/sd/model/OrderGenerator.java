package com.stu.sd.model;

import java.util.Random;

public class OrderGenerator {
    public static Order generate() {
        Order order = new Order();
        int orderId = random(1000000, 900000);
        int userId = random(20000000, 7000000);
        order.setId((long) orderId);
        order.setUserId((long) userId);
        return order;
    }

    private static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
