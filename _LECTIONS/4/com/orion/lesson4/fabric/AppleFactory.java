package com.orion.lesson4.fabric;

public class AppleFactory extends AbstractFruitFabric{

    public static class Apple extends Fruit {

        @Override
        public void describeFruit() {
            System.out.println("Маленькое яблоко красного цвета");
        }
    }

    @Override
    public Fruit makeFruit() {
        return new Apple();
    }
}
