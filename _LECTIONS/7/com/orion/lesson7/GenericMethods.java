package com.orion.lesson7;

import java.util.Arrays;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
        final List<String> x = makeSortedListFromPair("b", "a");
        final List<Integer> ints = makeSortedListFromPair(2, 1);
        System.out.println(x);
        System.out.println(ints);
    }



    public static <T extends Comparable<T>> List<T> makeSortedListFromPair(T first, T second) {
        final List<T> ts = Arrays.asList(first, second);
        ts.sort(null);
        return ts;
    }


}
