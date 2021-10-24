package com.orion.lesson5;

import java.util.Objects;

public class Equals {

    public static class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Animal animal = (Animal) o;
            return Objects.equals(name, animal.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }


    static class Dog extends Animal {
        String favoriteFood;


        public Dog(String name, String favoriteFood) {
            super(name);
            this.favoriteFood = favoriteFood;
        }

        @Override
        public boolean equals(Object o) {
            Dog dog = (Dog) o;
            return favoriteFood.equals(dog.favoriteFood) && dog.name.equals(name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), favoriteFood);
        }
    }

    public static void main(String[] args) {
    /*    Animal animal1 = new Animal("Barsik");
        Animal animal2 = new Animal("Barsik");

        System.out.println(animal1.equals(animal2));
        System.out.println(animal1 == animal2);*/

        Animal first = new Animal("Barsik");
        Dog another = new Dog("Barsik","Milk");


        System.out.println(first.equals(another));
        System.out.println(another.equals(first));


    }
}
