package task1;

import classes.*;

import java.util.*;


public class Task1 {
    public static void main(String[] args) {

        //task.a
        System.out.print("------\ntask.a\n------\n");

        Pair<Animal, String> fa = new Pair<>( new Animal("Лев","дикое") , "людей");
        Pair<Animal, String> ta = new Pair<>( new Animal("Кошка","домашнее"), "мышей");
        Pair<Animal, String> sa = new Pair<>( new Animal("Слон","дикое"), "беляшей");

        List<Pair<Animal, String> > list = new ArrayList<>();
        list.add(fa);
        list.add(sa);
        list.add(ta);

        AnimalCare.feedAnimals(list);

    }

}
