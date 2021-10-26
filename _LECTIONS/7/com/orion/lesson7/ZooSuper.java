package com.orion.lesson7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


public class ZooSuper {

    static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Elephant extends Animal {
        public Elephant(String name) {
            super(name);
        }
    }


    static class WildAnimal extends Animal {

        public WildAnimal(String name) {
            super(name);
        }
    }

    static class Dog extends WildAnimal {
        public Dog(String name) {
            super(name);
        }
    }

    static class Cat extends WildAnimal {
        public Cat(String name) {
            super(name);
        }


        public void meow() {
            System.out.println("MEOW!!!!");
        }
    }
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();
      //  System.out.println(zoo);
        fillZooWithWildAnimals(zoo);


        List<Object> someObjects = new ArrayList<>();
        someObjects.add("str");
        someObjects.add(1);
        fillZooWithWildAnimals(someObjects);


        System.out.println(someObjects);


        List<Cat> cats = new ArrayList<>();
        //  fillZooWithWildAnimals(cats); ошибка компиляции т.к. Cat не super для WildAnimal
    }



    public static void fillZooWithWildAnimals(Collection<? super WildAnimal> animals) {
        if (new Random().nextBoolean()) {
            animals.add(new Dog("random dog"));
        } else {
            animals.add(new Cat("random cat"));
        }
    }




}
