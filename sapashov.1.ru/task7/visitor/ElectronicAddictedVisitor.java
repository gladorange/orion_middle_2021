package task7.visitor;

import task7.ShopItem;
import task7.electricitems.ElectronicItem;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicAddictedVisitor implements Visitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {

    }

    public void buyElectricItemWithHighestPrice(Collection<? extends ShopItem> collection)  {
        List<? super ElectronicItem> myList = collection.stream().filter(shopItem -> shopItem instanceof ElectronicItem).collect(Collectors.toList());
        Optional<ElectronicItem> shopItem = getElectronicItemWithMaxPowerConsumption(myList);
        removeItem(collection, shopItem);
    }

    private Optional<ElectronicItem> getElectronicItemWithMaxPowerConsumption(Collection<? super ElectronicItem> collection) {
        List<ElectronicItem> collect = new ArrayList<>();
        for (Object shopItem : collection) {
            if (shopItem instanceof ElectronicItem) {
                collect.add((ElectronicItem) shopItem);
            }
        }

        Optional<ElectronicItem> max = collect.stream().max(Comparator.comparing(ElectronicItem::getPowerConsumption));
        return max;
    }

    private void removeItem(Collection<? extends ShopItem> collection, Optional<ElectronicItem> shopItem) {
        boolean isRemoved = collection.remove(shopItem.get());
        if (isRemoved) {
            System.out.println("Item sold: " + shopItem);
        } else {
            System.out.println("Some error, " + shopItem + " hasn't been removed");
        }
    }


}
