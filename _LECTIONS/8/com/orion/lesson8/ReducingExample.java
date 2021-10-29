package com.orion.lesson8;

import java.util.List;

public class ReducingExample {


    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Integer reduce = integers.stream()
                .reduce(0, Integer::sum);

        System.out.println(reduce);


    }
}
