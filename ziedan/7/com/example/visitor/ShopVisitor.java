package com.example.visitor;

import com.example.shopItem.ShopItem;

import java.util.ArrayList;

public interface ShopVisitor {

    <T extends ArrayList<? extends ShopItem>> void visitShop(T shop);

    default <T extends ArrayList<? extends ShopItem>> void buyItemFromShop(ShopItem item, T shop) {
        shop.remove(item);
        System.out.printf("%s куплен по %s%n", item.getName(), item.getPrice());
    }
}
