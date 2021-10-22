package com.orion.lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapsExample {


    static class Person {
        String name;
        String profession;

        public Person(String name, String profession) {
            this.name = name;
            this.profession = profession;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Вася", "Программист"));
        persons.add(new Person("Петя", "Программист"));
        persons.add(new Person("Маша", "Тестироващик"));
        persons.add(new Person("Вика", "Тестироващик"));

        final Map<String, List<Person>> collect = persons.stream()
                .collect(Collectors.groupingBy(p -> p.profession));

        System.out.println(collect);
    }
}
