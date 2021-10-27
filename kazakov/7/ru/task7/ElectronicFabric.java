package ru.task7;

import java.util.ArrayList;
import java.util.Collection;

/*
методом fillShopWithElectronicGoods. На вход передается коллекция(магазин) которую нужно заполнить.
 */
public class ElectronicFabric {
    public static void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop) {
        Collection<ElectronicItem> itemsToAdd = new ArrayList<>();
        //  В эту коллекцию нужно добавить несколько холодильников или телевизоров с разными свойствами и вывести на экран
        itemsToAdd.add(new Refrigerator("хол. Свияга", 15000.0, 200, 25));
        itemsToAdd.add(new Refrigerator("хол. Samsung", 45000.0, 750, 95));
        itemsToAdd.add(new Refrigerator("хол. Bosch", 65000.0, 1000, 150));
        itemsToAdd.add(new TV("TV LG", 15000.0, 100, 100));
        itemsToAdd.add(new TV("TV Sony", 25000.0, 150, 115));
        itemsToAdd.add(new TV("TV ViewSonic", 20000.0, 120, 110));
        shop.addAll(itemsToAdd);
        //  "В магазин добавлена электроника: список_товаров"
        System.out.print("В магазин добавлена электроника: ");
        itemsToAdd.forEach(x -> System.out.printf("%s, ", x.getName()));
        System.out.println();   //  force newline
    }
}
