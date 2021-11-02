package ru.task8.Person;

import java.util.*;

import static java.util.Comparator.comparing;

public class PersonMain {

    public static void main(String[] args) {

        /*
         Отсортируйте коллекцию сначала по имени, выведите на экран
          Затем - по возрасту, выведите на экран.

        Для сортировки используйте Collections.sort(collection, comparator)
        компаратор задайте в виде лямбда выражения или method reference
        */
        List<Person> persList = new ArrayList<>();
        persList.add(new Person("Вася", 31));
        persList.add(new Person("Петя", 26));
        persList.add(new Person("Ян", 17));
        persList.add(new Person("Маша", 19));
        persList.add(new Person("Вика", 24));
        persList.add(new Person("Антон", 42));
        persList.add(new Person("Олег", 24));
        persList.add(new Person("Anna", 20));
        persList.add(new Person("Dave", 18));

        //Collections.sort(persList, comparing(a -> a.getName()));
        Collections.sort(persList, comparing(Person::getName));
        persList.forEach(p -> System.out.printf("%s: %d\n", p.getName(), p.getAge()));
        //  Затем - по возрасту, выведите на экран.
        //Collections.sort(persList, (a, b) -> Integer.compare(a.getAge(), b.getAge()));
        //Collections.sort(persList, comparing(a -> a.getAge()));
        Collections.sort(persList, comparing(Person::getAge));
        persList.forEach(p -> System.out.printf("%s: %d\n", p.getName(), p.getAge()));
    }
}
