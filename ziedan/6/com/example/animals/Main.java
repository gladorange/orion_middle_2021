package com.example.animals;

import com.example.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final List<Pair<Animal, String>> animals = new ArrayList<>();

    static {
        animals.add(new Pair<>(new Animal("Шарик", "Собака"), "кости"));
        animals.add(new Pair<>(new Animal("Бурёнка", "корова"), "Сено"));
        animals.add(new Pair<>(new Animal("Пушок", "хомяк"), "петрушка"));
        animals.add(new Pair<>(new Animal("Белянка", "коза"), "деревья"));
        animals.add(new Pair<>(new Animal("Мурка", "кошка"), "фарш"));
        animals.add(new Pair<>(new Animal("Ветер", "конь"), "Сено"));
    }

    public static void main(String[] args) {
        feedAnimals(animals);
    }

    public static void feedAnimals(List<Pair<Animal, String>> pairs) {
        pairs.forEach(pair -> System.out.printf("Животное %s с радостью съедает %s%n", pair.getFirst().getName(), pair.getSecond()));

        Random random = new Random();
        Pair<Animal, String> pair = pairs.get(random.nextInt(pairs.size()));
        System.out.printf("Счастливое животное %s получает двойную порцию %s%n", pair.getFirst().getName(), pair.getSecond());
    }
}
