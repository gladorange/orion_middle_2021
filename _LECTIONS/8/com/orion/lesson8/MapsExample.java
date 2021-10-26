package com.orion.lesson8;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
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
            return "Person{" +
                    "name='" + name + '\'' +
                    ", profession='" + profession + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Вася", "Программист"));
        persons.add(new Person("Петя", "Программист"));
        persons.add(new Person("Маша", "Тестироващик"));
        persons.add(new Person("Вика", "Тестироващик"));


        for (Person person : persons) {
            System.out.println(person);
        }

    /*    final Map<String, List<String>> collect = persons.stream()
                .collect(
                        groupingBy(p -> p.profession,
                                mapping(person -> person.name, toList()))
                );

        System.out.println(collect);*/
    }
}
