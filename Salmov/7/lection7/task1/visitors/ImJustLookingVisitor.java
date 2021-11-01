package lection7.task1.visitors;

import lection7.task1.Shop;
import lection7.task1.items.ShopItem;

public class ImJustLookingVisitor implements ShopVisitor{
    @Override
    public void visitShop(Shop<? extends ShopItem> shopItems) {
        System.out.println("Я пришёл в " + shopItems.getName() + " просто посмотреть и вот какие товары я вижу:");
        for (ShopItem item: shopItems) {
            System.out.printf("%s %s - цена: %.2f р.\n", item.getType(), item.getName(), item.getPrice());
        }
        System.out.println();
    }
}
