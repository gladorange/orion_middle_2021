package com.orion.lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        Map<String, List<Person>> groupped = new HashMap<>();

        for (Person person : persons) {
            final List<Person> people = groupped.computeIfAbsent(person.profession, key -> new ArrayList<>());
            people.add(person);
        }

        System.out.println(groupped);
    }
}
