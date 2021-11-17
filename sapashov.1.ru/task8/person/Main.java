package task8.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Person Andrew = new Person("Andrew", 29);
        Person Boris = new Person("Boris", 23);
        Person Pavel = new Person("Pavel", 14);
        Person John = new Person("John", 40);

        personList.add(Andrew);
        personList.add(Boris);
        personList.add(Pavel);
        personList.add(John);

        // sort by name
        System.out.println("----------------sort by name---------------");
        Collections.sort(personList, Comparator.comparing(Person::getName));
        personList.forEach(System.out::println);


        Collections.sort(personList, Comparator.comparing(Person::getAge));
        // sort by age
        System.out.println("\n================sort by age===========================");
        personList.forEach(System.out::println);
    }
}
