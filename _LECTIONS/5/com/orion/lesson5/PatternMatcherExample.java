package com.orion.lesson5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {


    public static void main(String[] args) {


        String str = "<div>апельсин</div> яблоко ананас";


        System.out.println(str.contains("а"));

        Pattern pattern = Pattern.compile("<div>.*</div>.*");
        final Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());


    }
}
