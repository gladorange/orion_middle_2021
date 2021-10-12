package com.orion.lection.lesson3.innerclases;


public class OuterClass {
    int parentVariable = 42;


    static class  InnerClass {

        int innerVariable = 5;

        void printFromParent() {
           // System.out.println(parentVariable);
        }

    }


    public static void main(String[] args) {
       // InnerClass inner = new InnerClass();
        OuterClass outer = new OuterClass();

        final InnerClass innerClass = new InnerClass();


        innerClass.printFromParent();
        outer.parentVariable = 10;
        innerClass.printFromParent();



    }
}
