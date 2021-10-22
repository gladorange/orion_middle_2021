package com.orion.lection.lesson3.beans;

import java.util.Random;

public class Animal {

    public static final int ANIMAL_COUNT = 10;
    private String name;
    private int weight;

    public Animal() {
    }

    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }


    public static String getClassName() {
        return "Животное";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void say() {
        System.out.println("Животное ничего не говорит");
    }


    public static class Dog extends Animal {

        @Override
        public void say() {
            System.out.println("Гав");
        }



        public static String getClassName() {
            return "Собака";
        }



    }
    public static class Cat extends Animal {

        @Override
        public void say() {
            System.out.println("Мяу");
        }

        public static String getClassName() {
            return "Кошка";
        }

    }


    public static void main(String[] args) {
        Animal[] animals = new Animal[ANIMAL_COUNT];

        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Random().nextBoolean() ? new Dog() : new Cat();
        }

        for (Animal animal : animals) {
            animal.say();
            System.out.println(Animal.getClassName());
        }

    }


}
