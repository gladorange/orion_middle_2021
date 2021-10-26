package com.orion.lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LambdaCollectionsExacmples {


    public static void main(String[] args) {

/*

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 5, 2, 7, 235, 23, 12, 2));


        list.removeIf(integer -> integer % 2 != 0);

        System.out.println(list);
*/


        Map<String, Integer> map = new HashMap<>();

        final Integer strLength = map.computeIfAbsent("123", key -> "123".length());

        System.out.println(strLength);
        System.out.println(map.get("123"));

    }
}
