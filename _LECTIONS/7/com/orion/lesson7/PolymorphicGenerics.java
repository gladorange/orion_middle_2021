package com.orion.lesson7;

import java.util.ArrayList;
import java.util.List;

public class PolymorphicGenerics {

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }

    static class Dog extends Animal{
        public Dog(String name) {
            super(name);
        }
    }

    static class Cat extends Animal{
        public Cat(String name) {
            super(name);
        }


        public void meow() {
            System.out.println("MEOW!!!!");
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Sharik"));


        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik"));


        printAnimalNames(dogs);
      //  printAnimalNames(cats);

      //  addDogToList(dogs));
      //  addDogToList(cats));



    }


    static void printAnimalNames(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.name);
        }
    }

    static void addDogToList(List<Animal> animals) {
        animals.add(new Dog("Barbos"));
    }



}
