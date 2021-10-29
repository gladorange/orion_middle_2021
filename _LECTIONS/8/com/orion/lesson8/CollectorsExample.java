package com.orion.lesson8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectorsExample {


    public static void main(String[] args) {
        List<String> str = new ArrayList<>(List.of("1", "2", "-1", "-2", "0", "1"));


        final Collection<Integer> collect = str.stream()
                .map(Integer::valueOf)
                .filter(in -> in > 0)
                .collect(Collectors.toCollection(ArrayList::new));


        System.out.println(collect);


    }
}
