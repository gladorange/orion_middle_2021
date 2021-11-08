package task6.a;

import task6.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainA {
    public static void main(String[] args) {

        List<Pair<Animal, String>> animalsAndFood = new ArrayList<>();
        Pair<Animal, String> pair1 = new Pair<>(new Animal("Zor'ka", "cow"), "corn");
        Pair<Animal, String> pair2 = new Pair<>(new Animal("Druzhok", "dog"), "meat");
        Pair<Animal, String> pair3 = new Pair<>(new Animal("Barsik", "cat"), "fish");
        Pair<Animal, String> pair4 = new Pair<>(new Animal("Jerry", "mouse"), "cheese");
        Pair<Animal, String> pair5 = new Pair<>(new Animal("Snap", "dog"), "pedigree");
        Pair<Animal, String> pair6 = new Pair<>(new Animal("Sam", "cat"), "whiskas");
        Pair<Animal, String> pair7 = new Pair<>(new Animal("Vasya", "cat"), "kitekat");
        Pair<Animal, String> pair8 = new Pair<>(new Animal("Alex", "lion"), "meat");
        Pair<Animal, String> pair9 = new Pair<>(new Animal("Melman", "zebra"), "grass");
        Pair<Animal, String> pair10 = new Pair<>(new Animal("Motomoto", "hypo"), "grass");

        animalsAndFood.add(pair1);
        animalsAndFood.add(pair2);
        animalsAndFood.add(pair3);
        animalsAndFood.add(pair4);
        animalsAndFood.add(pair5);
        animalsAndFood.add(pair6);
        animalsAndFood.add(pair7);
        animalsAndFood.add(pair8);
        animalsAndFood.add(pair9);
        animalsAndFood.add(pair10);

        feedAnimals(animalsAndFood);
    }

    private static void feedAnimals(List<Pair<Animal, String>> list) {

        Collections.sort(list, (o1, o2) -> o1.getFirst().compare(o1.getFirst(), o2.getFirst()));

        int randomInteger = Random.getRandomInteger();
        for (Pair<Animal, String> pair : list) {
            System.out.printf("\nHappy animal %s enjoys %s", pair.getFirst(), pair.getSecond());
        }
        System.out.printf("\nAnd double portion goes to %s", list.get(randomInteger));
    }
}
