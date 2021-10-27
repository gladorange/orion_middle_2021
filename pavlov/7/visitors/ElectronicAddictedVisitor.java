package visitors;

import items.ShopItem;
import items.electronic.ElectronicItem;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicAddictedVisitor extends BuyerVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        List<ElectronicItem> electronicItemList = shop.stream()
                .filter(item -> (item instanceof ElectronicItem))
                .map(item -> (ElectronicItem) item)
                .collect(Collectors.toList());

        for(ElectronicItem item : electronicItemList){
            System.out.println(item.getDescription());
        }

        if(electronicItemList.size()>0){
            ElectronicItem minItem = Collections.min(electronicItemList, Comparator.comparingInt(ShopItem::getPrice));
            buy(electronicItemList, minItem);
        }
    }

}
