package com.orion.lesson4.fabric.except;

public class PersonExample {

    static class Person {
        int age;
        String name;

        public Person(int age, String name) throws InvalidAgeException {
            if (age < 0) {
                throw new InvalidAgeException("Возраст должен быть больше нуля, а передан отрицательный:" + age);
            }

            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(getVasyaAge());

        System.out.println("Конец");
    }

    private static int getVasyaAge() {
        final Person vasya;
        try {
            vasya = new Person(-42, "Vasya");
            return vasya.age;
        } catch (InvalidAgeException e) {
            System.out.println("Вася не получился");
            throw new RuntimeException();
        } finally {
            return 100;
        }

    }
}
