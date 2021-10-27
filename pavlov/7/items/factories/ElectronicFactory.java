package items.factories;

import items.ShopItem;
import items.electronic.ElectronicItem;
import items.electronic.Refrigerator;
import items.electronic.TV;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class  ElectronicFactory {
    public void fillShopWithElectronicGoods(Collection<? super ElectronicItem> shop){
        List<ElectronicItem> addedList = new LinkedList<>();
        addedList.add(new TV("Телевизор 1", 1000, 100, 100));
        addedList.add(new TV("Телевизор 2", 2000, 200, 200));
        addedList.add(new Refrigerator("Холодильник 1", 1000, 100, 100));
        addedList.add(new Refrigerator("Холодильник 2", 2000, 200, 200));

        List<String> descriptionList = addedList.stream()
                .map(ShopItem::getDescription)
                .collect(Collectors.toList());

        shop.addAll(addedList);
        System.out.printf("В магазин добавлена электроника: %s\n", descriptionList);
    }
}
