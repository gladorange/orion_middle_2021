package com.orion.lesson8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatMap {


    public static void main(String[] args) {
        String[] strings = {
                "some long long long string with english letters",
                "another string",
                "yet another string"

        };


        final Map<Character,Long> collect =
                Stream.of(strings)
                        .flatMapToInt(str -> str.chars())
                        .mapToObj(in -> Character.valueOf((char) in))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting() ));


        System.out.println(collect);

      /*  final Map<Character, Integer> charCount = new HashMap<>();
        for (Entry<Character, List<Character>> characterListEntry : collect.entrySet()) {
            charCount.put(characterListEntry.getKey(), characterListEntry.getValue().size());
        }

        System.out.println(charCount);*/

    }
}
