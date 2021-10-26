package com.example.factories;

import com.example.shopItem.Apple;

import java.util.*;

public class AppleGarden {
    private static List<Apple> apples = new ArrayList<>();

    static {
        apples.add(new Apple("Яблоки Ред", 89.90, 52, 10, "Красное"));
        apples.add(new Apple("Яблоко Ред Чиф", 110.0, 52, 10, "Красное"));
        apples.add(new Apple("Яблоки Гренни", 99.90, 52, 10, "Зеленое"));
        apples.add(new Apple("Яблоко Голден", 78.00, 52, 10, "Зеленое"));
    }

    public static <T extends ArrayList<? super Apple>> void fillShopWithApples(T shop) {
        Random random = new Random();
        Set<String> addedAppleColors = new HashSet<>();
        int anInt = random.nextInt(20);

        for (int i = 0; i < anInt; i++) {
            Apple e = apples.get(random.nextInt(apples.size()));
            shop.add(e);
            addedAppleColors.add(e.getColor());
        }

        if (!addedAppleColors.isEmpty()) {
            System.out.printf("В магазин добавлена Яблоки: %s %n", String.join(", \n", addedAppleColors));
        }
    }
}
