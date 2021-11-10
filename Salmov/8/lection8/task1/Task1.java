package lection8.task1;
//Домашнее задание к лекции 8
//Лямбда-выражения и потоки
//Person
//Салмов Евгений

import lection6.tuples.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Task1 {
    final static String[] NAMES = {"Пётр","Виктор","Алексей","Леонид","Лена",
            "Александр","Владимир","Станислав","Алевтина","Марина","Ангелина"};
    final static int MAX_AGE = 48;
    final static int MIN_AGE = 18;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        for (String name: NAMES) {
            persons.add(new Person(name, random.nextInt(MAX_AGE-MIN_AGE)+MIN_AGE));
        }
        System.out.println("Исходный список людей:");
        System.out.println(persons);
        persons.sort(Comparator.comparing(p -> p.getName()));
        System.out.println("Список людей, отсортированный по имени:");
        System.out.println(persons);
        persons.sort(Comparator.comparing(Person::getAge));
        System.out.println("Список людей, отсортированный по возрасту:");
        System.out.println(persons);
    }

}
