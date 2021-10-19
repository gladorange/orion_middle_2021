package com.orion.lesson6;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortedSetsExample {


    static class Person implements Comparable<Person> {
        String name;
        String lastName;

        public Person(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return lastName + " " + name;
        }

        @Override
        public int compareTo(Person o) {
            final int i = lastName.compareToIgnoreCase(o.lastName);
            if (i == 0) {
                return name.compareToIgnoreCase(o.name);
            }
            return i;
        }
    }

    static class PersonWithAge extends Person {
        int age;

        public PersonWithAge(String name, String lastName, int age) {
            super(name, lastName);
            this.age = age;
        }

        @Override
        public String toString() {
            return "PersonWithAge{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {

        /*Set<Person> persons = new TreeSet<>();
        persons.add(new Person("Vasya", "Andreev"));

        persons.add(new Person("Petya", "Ivanov"));
        persons.add(new Person("Petya", "Bbbb"));
        persons.add(new Person("Petya", "ccccc"));
        persons.add(new Person("Petya", "xxxx"));
        persons.add(new Person("Petya", "dddd"));

        persons.add(new Person("Petya", "Andreev"));

        System.out.println(persons);*/


        testAge();
    }

    private static void testAge() {
        final PersonWithAge masha = new PersonWithAge("Masha", "Ivanova", 18);
        final PersonWithAge petya = new PersonWithAge("Petya", "Ivanov", 30);
        final PersonWithAge vasya = new PersonWithAge("Vasya", "Ivanov", 12);
        final PersonWithAge vika = new PersonWithAge("Vika", "Ivanov", 12);


        Comparator<PersonWithAge> comparator = Comparator
                .comparingInt((PersonWithAge o) -> o.age)
                .thenComparing(p -> p.lastName)
                .thenComparing(p -> p.name);

        TreeSet<PersonWithAge> persons = new TreeSet<>(comparator);
        persons.add(masha);
        persons.add(petya);
        persons.add(vasya);
        persons.add(vika);

        System.out.println(persons);
    }
}
