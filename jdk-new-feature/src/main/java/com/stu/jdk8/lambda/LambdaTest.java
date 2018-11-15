package com.stu.jdk8.lambda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by gut on 9/28/18.
 */
public class LambdaTest {

    public static void main(String[] args) {
        Function<String, Integer> stringToInt = (s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInt1 = Integer::parseInt;

        BiPredicate<List<String>, String> iscontains = (list, str) -> list.contains(str);
        BiPredicate<List<String>, String> iscontains1 = List::contains;

        Supplier<String> supplier = String::new;
        supplier.get();

        Function<String, StringBuffer> sbf = StringBuffer::new;
        StringBuffer sb = sbf.apply("test");
    }
}
