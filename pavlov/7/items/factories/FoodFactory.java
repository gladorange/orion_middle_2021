package items.factories;

import items.ShopItem;
import items.foods.Apple;
import items.foods.Bread;
import items.foods.FoodItem;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFactory {
    public void fillShopWithFood(Collection<? super FoodItem> shop){
        Collection<FoodItem> foods = new LinkedList<>();
        foods.add(new Apple("яблоко", 100, 100, "Зеленое"));
        foods.add(new Apple("яблоко", 100, 100, "Красное"));
        foods.add(new Apple("яблоко", 100, 100, "Желтое"));
        foods.add(new Bread("Белый", 100, 100, 100));
        foods.add(new Bread("Бородинский", 100, 100, 200));
        foods.add(new Bread("Черный", 100, 100, 300));
        foods.add(new Bread("Сладкий", 100, 100, 400));

        List<String> descriptionList = foods.stream()
                .filter(item -> item instanceof Apple)
                .map(ShopItem::getDescription)
                .collect(Collectors.toList());

        int weight = foods.stream()
                .filter(item -> item instanceof Bread)
                .map(item -> (Bread) item)
                .map(Bread::getWeight)
                .reduce(Integer::sum)
                .orElse(0);

        shop.addAll(foods);
        System.out.printf("В магазин добавлены яблоки: %s, и хлеба общим весом: %s\n", descriptionList, weight);
    }
}
