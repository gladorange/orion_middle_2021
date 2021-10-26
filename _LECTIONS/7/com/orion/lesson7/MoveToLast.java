package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;

public class MoveToLast {


    public static void main(String[] args) {
        List<String> str = new ArrayList<>();


        reinsertGeneric(str);
    }



    static <T extends Object> void reinsertGeneric(List<T> list) {
        final T o = list.get(0);
        list.add(o);
    }


   /* static void reinsert(List<?> list) {
        final Object o = list.get(0);
        list.add(o);
    }*/
}
