package com.example8.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Shadi", 32));
        people.add(new Person("Ahmed", 34));
        people.add(new Person("Ahmed", 32));
        people.add(new Person("Karim", 29));
        people.add(new Person("Muhammad", 30));
        people.add(new Person("Salma", 26));

        Collections.sort(people, Comparator.comparing(Person::getName));

        System.out.println(people);

        Collections.sort(people, Comparator.comparing(Person::getAge));

        System.out.println(people);

        Collections.sort(people, Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge));

        System.out.println(people);

    }
}
