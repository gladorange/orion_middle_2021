package com.orion.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {





    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("1", "2", "10", "100", "200", "1000"));


        final Stream<String> sorted = strings
                .stream()
                .sorted();

        System.out.println(sorted.collect(Collectors.toList()));

        final Stream<Integer> integerStream = strings
                .stream()
                .map(Integer::parseInt)
                .sorted();

        System.out.println(integerStream.toList());


        final Stream<String> stream = strings.stream().sorted();

        strings.removeIf(str -> str.startsWith("1"));

        System.out.println(stream.count());

    }
}
