package com.orion.lesson4.fabric;

import java.util.Random;

import com.orion.lesson4.fabric.AbstractFruitFabric.Fruit;

public class FactoryMain {


    public static void main(String[] args) {
        AbstractFruitFabric someFabric = getSomeFabric();
        final Fruit fruit = someFabric.makeFruit();
        fruit.describeFruit();
    }




    private static AbstractFruitFabric getSomeFabric() {
        if (new Random().nextBoolean()) {
            return new OrangeFactory();
        } else {
            return new AppleFactory();
        }
    }
}
