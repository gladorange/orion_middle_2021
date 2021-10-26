package com.orion.lesson7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapComparator {


    public static void main(String[] args) {

        Map<String, String> lastNameToName = new HashMap<>();

        lastNameToName.put("Pupkin", "Vasiliy");
        lastNameToName.put("Ivanov", "Petya");
        lastNameToName.put("Antonov", "Yan");


        System.out.println(lastNameToName);

        final ArrayList<Entry<String, String>> entries = new ArrayList<>(lastNameToName.entrySet());


        entries.sort(Map.Entry.comparingByKey());
        System.out.println(entries);



        entries.sort(Map.Entry.comparingByValue());
        System.out.println(entries);

        entries.sort(Map.Entry.comparingByValue(Comparator.comparing(s -> s.length())));
        System.out.println(entries);


    }
}
