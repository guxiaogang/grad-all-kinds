package com.stu.jdk8.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.stu.jdk8.stream.Menu.menu;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by gut on 10/11/18.
 */
public class GroupTest {
    @Test
    public void testGroup() {
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(groupingBy(d -> d.getType()));
        System.out.println(collect);
    }

    @Test
    public void testTwoLevelGroup() {
        Function<Dish, Dish.CaloricLevel> fun = dish -> {
            if (dish.getCalories() <= 400) {
                return Dish.CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return Dish.CaloricLevel.NORMAL;
            } else {
                return Dish.CaloricLevel.FAT;
            }
        };

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> collect = menu.stream()
                .collect(groupingBy(Dish::getType, groupingBy(fun)));

        System.out.println(collect);
    }
}
