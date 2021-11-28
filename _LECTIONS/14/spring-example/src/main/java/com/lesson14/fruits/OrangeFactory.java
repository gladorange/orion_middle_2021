package com.lesson14.fruits;


import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OrangeFactory implements FruitFactory {
    static class Orange extends Fruit{

        Orange() {
            super("Orange" + new Random().nextInt(100));
        }
    }


    @Override
    public Fruit makeFruit() {
        return new Orange();
    }
}
