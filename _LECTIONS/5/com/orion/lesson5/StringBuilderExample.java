package com.orion.lesson5;

public class StringBuilderExample {


    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4"};

        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s).append(",");
        }




        System.out.println(result);
        System.out.println(str[0] + str[1] );
    }
}
