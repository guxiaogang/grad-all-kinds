package com.stu.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by gut on 9/28/18.
 */
public class StreamTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    public void test1() {
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);

    }

    @Test
    public void test4() {
        transactions.stream()
                .map(t1 -> t1.getTrader().getName())
                .distinct()
                .reduce("", (t1, t2) -> t1 + t2);
    }

    @Test
    public void test5() {
        transactions.stream()
                .map(t1 -> t1.getTrader().getCity())
                .distinct()
                .allMatch(s -> s.equals("Milan"));
    }

    @Test
    public void test6() {
        transactions.stream()
                .filter(t1 -> t1.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);
    }

    @Test
    public void test7() {
        transactions.stream()
                .max(comparing(Transaction::getValue)).
                ifPresent(System.out::println);
    }

    @Test
    public void test8() {
        transactions.stream()
                .min(comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
