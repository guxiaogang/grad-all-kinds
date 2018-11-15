package com.stu.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.stu.jdk8.stream.Menu.menu;

/**
 * Created by gut on 9/28/18.
 */
public class FilterAndSliceTest {

    @Test
    public void filterForVegetarian() {
        menu.stream().filter(Dish::isVegetarian).forEach(System.out::println);
    }

    @Test
    public void oodAndDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void skipAndLimit() {
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .limit(3)
                .forEach(System.out::println);
    }
}
