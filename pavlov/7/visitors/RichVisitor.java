package visitors;

import items.ShopItem;

import java.util.Collection;
import java.util.LinkedList;

public class RichVisitor extends BuyerVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        Collection<ShopItem> boughtItems = new LinkedList<>();

        int count = 1;
        for(ShopItem item : shop){
            if(count%2 ==0){
                boughtItems.add(item);
            }
            count++;
        }

        for(ShopItem item: boughtItems){
            buy(shop, item);
        }
    }
}
