package com.lesson14.fruits;


import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AppleFactory implements FruitFactory {
    static class Apple  extends Fruit{

        Apple() {
            super("Apple " + new Random().nextInt(100));

        }
    }


    @Override
    public Fruit makeFruit() {
        return new Apple();
    }
}
