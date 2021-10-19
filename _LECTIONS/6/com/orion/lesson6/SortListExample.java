package com.orion.lesson6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListExample {

    public static void main(String[] args) {
        List<String> sortedList = new ArrayList<>();
        sortedList.add("a");
        sortedList.add("bb");
        sortedList.add("ccc");
        sortedList.add("dd");
        sortedList.add("zzzzzzzzz");
        sortedList.add("eeee");


        Collections.sort(sortedList);
        System.out.println(sortedList);


        Collections.sort(sortedList, Comparator.comparing( (String s) -> s.length()).reversed());
        System.out.println(sortedList);

        final String max = Collections.max(sortedList, Comparator.comparing(s -> s.length()));
        System.out.println(max);


    }
}
