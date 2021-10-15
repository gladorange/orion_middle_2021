package com.orion.lesson5;

public class CloneExample {


    static class Person implements Cloneable {
        String name;

        public Person(String name) {
            this.name = name;
        }


        public Person(Person person) {
            name = person.name;
        }

        public Person clone() throws CloneNotSupportedException {
            return (Person) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Person vasya = new Person("Vasya");
        final Person clone = (Person) vasya.clone();
        System.out.println(clone.name);
    }
}
