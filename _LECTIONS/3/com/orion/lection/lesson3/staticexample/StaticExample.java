package com.orion.lection.lesson3.staticexample;

import java.util.Random;

public class StaticExample {

    public static int RANDOM_VALUE;
    static {
        final Random random = new Random();
        RANDOM_VALUE = random.nextInt(100);
        System.out.println("инициализация завершена");
    }


    public int instanceVariable;
    {
        final Random random = new Random();
        instanceVariable = random.nextInt(100);
        System.out.println("инициализация  завершена");
    }


}
