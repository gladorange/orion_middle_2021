package ru.task7;

import java.util.ArrayList;
import java.util.Collection;

/*
AppleGarden - с методом fillShopWithApples. На вход передается коллекция(магазин) которую нужно заполнить.
        В эту коллекцию нужно добавить яблок разных цветов.
         Вывести на экран     "В магазин добавлены яблоки: список_цветов"
*/
public class AppleGarden {
    public static void fillShopWithApples(Collection<? super Apple> shop) {

        Collection<Apple> itemsToAdd = new ArrayList<>();
        //  В эту коллекцию нужно добавить яблок разных цветов.
        itemsToAdd.add(new Apple("Ренет Крюднера", 75.50, 25, 60, "розовые с красным бочком"));
        itemsToAdd.add(new Apple("Июльское Черненко", 79.50, 19, 60, "желтые с красным бочком"));
        itemsToAdd.add(new Apple("Антоновка", 75.0, 15, 90, "зелёные с желтым бочком"));
        itemsToAdd.add(new Apple("Red Delicious", 135.50, 46, 35, "красный"));
        itemsToAdd.add(new Apple("Медуница", 85.50, 25, 60, "желтые с красным бочком"));
        shop.addAll(itemsToAdd);
        //  Вывести на экран     "В магазин добавлены яблоки: список_цветов"
        System.out.print("В магазин добавлены яблоки: ");
        itemsToAdd.forEach(x -> System.out.printf("%s, ", x.getName()));
        System.out.println();   //  force newline
    }
}
