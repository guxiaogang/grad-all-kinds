package com.stu.jdk8.funinterface;

import java.util.Date;

/**
 * Created by gut on 9/17/18.
 */
public class TestFunctionInterface {

    @FunctionalInterface
    interface TestFun {
        void print();
    }

    public static void print(TestFun testFun) {
        testFun.print();
    }

    public static void main(String[] args) {
        print(() -> {
            System.out.println(new Date().getTime());
            System.out.println(new Date().getTime());
        });
    }
}
