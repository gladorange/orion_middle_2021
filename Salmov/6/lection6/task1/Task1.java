package lection6.task1;
//Домашнее задание к лекции 6
//Пара-Тройка кортежей
//Задание А
//Работа с парами
//Салмов Евгений

import lection6.tuples.Pair;
import lection6.tuples.Triple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        String[] names = {"Барсик","Мурзик","Бобби","Том","Джерри"};
        String[] types = {"кот","собака","мышь"};
        String[] dishes = {"Вискас","Китикэт","Чаппи","Роял-канин","Педигрипал"};
        Random random = new Random();
        List<Pair<Animal,String>> animals = new ArrayList<>();
        for (String name: names) {
            animals.add(new Pair<>(new Animal(name, types[random.nextInt(types.length)]),
                    dishes[random.nextInt(dishes.length)] ));
        }
        printAnimalsList(animals);
        System.out.println();
        feedAnimals(animals);
    }

    private static void printAnimalsList(List<Pair<Animal,String>> animals) {
        for (Pair<Animal,String> animal: animals )
            System.out.printf("%s %s любит %s\n", animal.getFirst().getType(),
                    animal.getFirst().getName(),
                    animal.getSecond());
    }

    private static void feedAnimals(List<Pair<Animal,String>> animals){
        System.out.println("Покормим животных:");
        Random random = new Random();
        int luckyAnimal = random.nextInt(animals.size());
        for (int i = 0; i < animals.size(); i++) {
            Pair<Animal,String> a = animals.get(i);
            if(i==luckyAnimal) {
                System.out.printf("Счастливое животное %s получает двойную порцию %s\n",
                        a.getFirst().getName(), a.getSecond());
            } else {
                System.out.printf("Животное %s с радостью съедает %s\n",
                        a.getFirst().getName(), a.getSecond());
            }
        }
    }
}
