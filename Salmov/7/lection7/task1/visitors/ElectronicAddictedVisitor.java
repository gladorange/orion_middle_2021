package lection7.task1.visitors;

import lection6.task2.Task2;
import lection6.tuples.Triple;
import lection7.task1.Shop;
import lection7.task1.items.ElectronicItem;
import lection7.task1.items.ShopItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElectronicAddictedVisitor implements ShopVisitor{
    @Override
    public void visitShop(Shop<? extends ShopItem> shopItems) {
        System.out.println("Я пришёл в " + shopItems.getName() + " посмотреть электронные товары и вот что я вижу:");
        List<? extends ShopItem> filteredList = shopItems.stream().filter(
                item -> (item instanceof ElectronicItem)).collect(Collectors.toList());
        if( filteredList.size() < 1) {
            System.out.println("В магазине " + shopItems.getName() + " нет электронных товаров");
        } else {
            for (ShopItem item: filteredList) {
                System.out.printf("%s %s - цена: %.2f р.\n", item.getType(), item.getName(), item.getPrice());
            }
            final ShopItem max = Collections.max(filteredList,
                    Comparator.comparing(i -> ((ElectronicItem) i).getPowerConsumption()));
            System.out.printf("%s %s куплен по цене: %.2f р.\n", max.getType(), max.getName(), max.getPrice());
            shopItems.removeIf(p -> (p instanceof ElectronicItem) &&
                    (Objects.equals(((ElectronicItem) p).getPowerConsumption(), ((ElectronicItem) max).getPowerConsumption())));
        }
        System.out.println();
    }
}
