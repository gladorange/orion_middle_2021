package com.orion.lesson6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SetsExample {



    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    public static void main(String[] args) {
       /* Set<Person> persons = new HashSet<>();

        Person vasya = new Person("vasya");
        persons.add(vasya);

        vasya.name = "Vasya";

        System.out.println(persons.contains(vasya));
*/
/*
        final boolean result = persons.add(vasya);

        System.out.println(result);
        System.out.println(persons.size());*/






    /*    persons.add(new Person("Вася"));
        final boolean result = persons.add(new Person("Вася"));


        System.out.println(result);
        System.out.println(persons.size());*/


        printOrder();
    }

    private static void printOrder() {
        Set<String> strings = new HashSet<>();
        strings.add("A");
        strings.add("B");
        strings.add("42");
        strings.add("13");
        strings.add("100500");
        strings.add("zoo");


        System.out.println("HashSet:" + strings);


        Set<String> linked = new LinkedHashSet<>();
        linked.add("A");
        linked.add("B");
        linked.add("42");
        linked.add("13");
        linked.add("100500");
        linked.add("zoo");


        System.out.println("LinkedHashSet:" + linked);
    }


}
