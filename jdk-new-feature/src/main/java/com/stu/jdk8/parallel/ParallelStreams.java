package com.stu.jdk8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * Created by gut on 10/19/18.
 */
public class ParallelStreams {

    public static long parallelSum(long n) {

        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, (a, b) -> a + b);
    }

    public static long sequentialSum(Long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }


    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static void main(String[] args) {
        System.out.println("IterativeSum sum done in:" + measureSumPerf(ParallelStreams::iterativeSum, 10_000_000_00l) + " msecs");
        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreams::sequentialSum, 10_000_000_00l) + " msecs");
        System.out.println("ParallelSum sum done in:" + measureSumPerf(ParallelStreams::parallelSum, 10_000_000_00l) + " msecs");
    }


}
