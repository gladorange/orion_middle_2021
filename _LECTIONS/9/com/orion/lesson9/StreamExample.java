package com.orion.lesson9;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {


    private static boolean isPersonValid(Person person) {
        if (person.name.startsWith("V")) {
            return person.age > 18;
        } else {
            return true;
        }
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Vasya", 18));
        persons.add(new Person("Petya", 12));
        persons.add(new Person("Sveta", 13));


        persons.stream()
                .filter(p -> isPersonValid(p))
                .mapToInt(p -> p.name.length())
                .sum();


    }
}
