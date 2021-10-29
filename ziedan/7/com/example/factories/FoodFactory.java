package com.example.factories;

import com.example.shopItem.Apple;
import com.example.shopItem.Bread;
import com.example.shopItem.FoodItem;

import java.util.*;

public class FoodFactory {

    private static List<Apple> apples = new ArrayList<>();
    private static List<Bread> breads = new ArrayList<>();

    static {
        apples.add(new Apple("Яблоки Ред", 89.90, 52, 10, "Красное"));
        apples.add(new Apple("Яблоко Ред Чиф", 110.0, 52, 10, "Красное"));
        apples.add(new Apple("Яблоки Гренни", 99.90, 52, 10, "Зеленое"));
        apples.add(new Apple("Яблоко Голден", 78.00, 52, 10, "Зеленое"));

        breads.add(new Bread("Батон молочный", 31.95, 12, 3, 300));
        breads.add(new Bread("Хлеб Паве подовый", 39.95, 12, 3, 400));
        breads.add(new Bread("Хлебобулочные изделия Хорватские", 34.95, 12, 3, 300));
        breads.add(new Bread("Изделия хлебобулочные Деревенские", 58.00, 12, 3, 300));
    }

    public static <T extends ArrayList<? super FoodItem>> void fillShopWithFood(T shop) {
        Random random = new Random();
        int addedBreadWeight = 0;
        Set<String> colors = new HashSet<>();
        for (int i = 0; i < random.nextInt(10); i++) {
            if (random.nextBoolean()) {
                Bread e = breads.get(random.nextInt(breads.size()));
                shop.add(e);
                addedBreadWeight += e.getWeight();
            } else {
                Apple e = apples.get(random.nextInt(apples.size()));
                shop.add(e);
                colors.add(e.getColor());
            }
        }

        System.out.printf("В магазин добавлены яблоки: %s и хлеба, общим весом: %s%n", String.join(", ", colors), addedBreadWeight);

    }
}
