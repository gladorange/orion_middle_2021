package lection7.task1.visitors;

import lection7.task1.Shop;
import lection7.task1.items.ShopItem;

public interface ShopVisitor {
    void visitShop(Shop<? extends ShopItem> shopItems);
}
