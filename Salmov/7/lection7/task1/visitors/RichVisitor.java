package lection7.task1.visitors;

import lection7.task1.Shop;
import lection7.task1.items.ShopItem;

import java.util.Iterator;

public class RichVisitor implements ShopVisitor{
    @Override
    public void visitShop(Shop<? extends ShopItem> shopItems) {
        System.out.println("Я пришёл в " + shopItems.getName() + " чтобы купить каждый второй товар!");
        Iterator<? extends ShopItem> i = shopItems.iterator();
        boolean secondItem = false;
        while (i.hasNext()) {
            ShopItem item = i.next();
            if(secondItem) {
                System.out.printf("%s %s куплен по цене: %.2f р.\n", item.getType(), item.getName(), item.getPrice());
                i.remove();
                secondItem = false;
            } else {
                secondItem = true;
            }
        }
        System.out.println();
    }
}
