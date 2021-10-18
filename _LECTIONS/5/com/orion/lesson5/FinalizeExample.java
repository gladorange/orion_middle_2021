package com.orion.lesson5;

public class FinalizeExample {



    static class Person {

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("final");
        }
    }


    public static void main(String[] args) {
        Person p = new Person();
        p = null;
        System.gc();

    }
}
