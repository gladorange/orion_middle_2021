package items.factories;

import items.foods.Apple;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class AppleGarden {
    public void fillShopWithApples(Collection<? super Apple> shop){
        Collection<Apple> apples = new LinkedList<>();
        apples.add(new Apple("яблоко", 100, 100, "Зеленое"));
        apples.add(new Apple("яблоко", 100, 100, "Красное"));
        apples.add(new Apple("яблоко", 100, 100, "Желтое"));

        Set<String> colors = apples.stream()
                .map(Apple::getColor)
                .collect(Collectors.toSet());

        shop.addAll(apples);
        System.out.printf("В магазин добавлены яблоки: %s\n", colors.toString());
    }
}
