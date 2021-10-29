package com.example.visitor;

import com.example.shopItem.ShopItem;

import java.util.ArrayList;

public class RichVisitor implements ShopVisitor {

    @Override
    public <T extends ArrayList<? extends ShopItem>> void visitShop(T shop) {
        ShopItem item = shop.size() >= 2 ? shop.get(1) : null;
        if (item != null) {
            buyItemFromShop(item, shop);
        }
    }

}
