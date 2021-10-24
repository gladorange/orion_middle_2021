package com.orion.lesson5;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);

        // List<Number> number = new ArrayList<Integer>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        System.out.println(list.size());
/*

        for (String s : list) {
            System.out.println(s);
        }
*/


        for (String s : list) {
            if (s.equals("4")) {
                list.remove("5");
            }
            System.out.println(s);
        }


       // List<String> anotherList = new LinkedList<>();


    }
}
