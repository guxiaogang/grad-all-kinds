package com.stu.jdk8.funinterface;


import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceTest {

    @Test
    public void testFunction() {
        Function<String, String> function = s -> "_" + s;
        Assert.assertEquals("_hello", function.apply("hello"));
    }

    @Test
    public void testConsumer() {
        Consumer<String> stringConsumer = (String s) -> System.out.println(s);
        stringConsumer.accept("Hello");
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicate = s -> s.equals("hello");
        Assert.assertEquals(true, predicate.test("hello"));
    }

    @Test
    public void testSupplier() {
        boolean a = false;
        Supplier<String> supplier = () -> "hello";
        Assert.assertEquals("hello", supplier.get());
        System.out.printf(String.valueOf(a));
    }
}
