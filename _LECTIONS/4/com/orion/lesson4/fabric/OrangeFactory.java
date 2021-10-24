package com.orion.lesson4.fabric;

public class OrangeFactory extends AbstractFruitFabric{

    public static class Orange extends Fruit {

        @Override
        public void describeFruit() {
            System.out.println("Большой апельсин оранжевого цвета");
        }
    }

    @Override
    public Fruit makeFruit() {
        return new Orange();
    }
}
