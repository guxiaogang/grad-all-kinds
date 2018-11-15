package com.stu.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static com.stu.jdk8.stream.Menu.menu;
import static java.util.stream.Collectors.joining;

/**
 * Created by gut on 9/28/18.
 */
public class MapTest {
    @Test
    public void getTheLengthOfDashName() {
        menu.stream()
                .map(dish -> dish.getName().length())
                .forEach(System.out::println);
    }

    @Test
    public void getCharList() {
        String[] strs = {"hello", "world"};
        Stream.of(strs).map(s -> s.split(""))
                .flatMap(strings -> Stream.of(strings))
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void getSqrtValues() {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(integer -> integer % i == 0)
                        .map(j -> new int[]{i, j})
                )
                .forEach(ints -> System.out.println(ints[0] + "-" + ints[1]));
    }

    @Test
    public void testMap() {
        menu.stream()
                .map(dish -> {
                    dish.setName("bbc");
                    return dish;
                })
                .forEach(System.out::println);
    }

    @Test
    public void testReduceing() {
        String collect = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(collect);
    }

    @Test
    public void testFlatmap() {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>() {{
            put("a", new HashSet<String>() {{
                add("align");
                add("alias");
            }});
            put("b", new HashSet<String>() {{
                add("break");
                add("book");
            }});
        }};
        map.entrySet().stream().flatMap(e -> e.getValue().stream()).forEach(System.out::println);
    }
}

