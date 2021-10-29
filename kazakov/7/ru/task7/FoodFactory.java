package ru.task7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

public class FoodFactory {
    /*
    FoodFactory - с методом fillShopWithFood. На вход передается коллекция(магазин) которую нужно заполнить.
    В эту коллекцию нужно добавить немного яблок и немного хлеба. Вывести на экран
"В магазин добавлены яблоки: список_цветов и хлеба, общим весом: вес_в_граммах"
    */
    public static void fillShopWithFood(Collection<? super FoodItem> shop) {
        Collection<FoodItem> itemsToAdd = new ArrayList<>();
        AtomicReference<Integer> totalWeight = new AtomicReference<>(0);
        //  В эту коллекцию нужно добавить немного яблок и немного хлеба. Вывести на экран
        itemsToAdd.add(new Apple("Jonagold", 130.35, 45, 35, "Yellow-red"));
        itemsToAdd.add(new Bread("хлеб Бородинский", 35.0, 50, 3, 300));
        itemsToAdd.add(new Bread("хлеб Посольский", 25.0, 55, 3, 300));
        itemsToAdd.add(new Bread("Батон нарезной", 30.0, 60, 3, 300));
        shop.addAll(itemsToAdd);
        //  Вывести на экран     "В магазин добавлены яблоки: список_цветов"
        itemsToAdd.forEach(x -> {
            if (x instanceof Bread)
                totalWeight.updateAndGet(v -> v + ((Bread) x).getWeight()); } );
        System.out.printf("В магазин добавлен хлеб.изделия общим весом: %d грамм\n", totalWeight.get());
    }
}
