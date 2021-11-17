package task1;

import task1.classes.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {
    public static void main(String[] args) {

        ArrayList<Person> personCollection = new ArrayList<>();

        Person p1 = new Person("Вася",13);
        Person p2 = new Person("Антон",43);
        Person p3 = new Person("Ваня",3);
        Person p4 = new Person("Андрей",20);
        Person p5 = new Person("Николай",19);
        Person p6 = new Person("Павел",19);
        Person p7 = new Person("Михаил",32);
        personCollection.add(p1);
        personCollection.add(p2);
        personCollection.add(p3);
        personCollection.add(p4);
        personCollection.add(p5);
        personCollection.add(p6);
        personCollection.add(p7);

        Collections.sort(personCollection, Comparator.comparing(a-> a.getName()   ));
        System.out.print(personCollection+"\n");
        Collections.sort(personCollection, Comparator.comparing(a-> a.getAge()   ));
        System.out.print(personCollection+"\n");


    }
}
