package com.xu.java8.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Class java8-并行stream和串行stream比较
 *
 * @author hua xu
 * @version 1.0.0
 * @date 16/08/31
 */
public class Streams3 {
    public static final int MAX = 2000000;

    public static void sortSequential() {
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            values.add(UUID.randomUUID().toString());
        }

        long t0 = System.nanoTime();
        long count = values.stream().sorted(( a, b ) -> a.compareTo(b)).count();
        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void sortParallel() {
        List<String> values = new ArrayList<>(MAX);
        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static void main(String[] args) {
        sortSequential();
        sortParallel();
    }
}