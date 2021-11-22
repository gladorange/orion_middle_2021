package com.lesson14.fruits;

import lombok.ToString;

public interface FruitFactory {

    @ToString
    static abstract class Fruit {
        final String name;

        protected Fruit(String name) {
            this.name = name;
        }
    }


    Fruit makeFruit();
}
