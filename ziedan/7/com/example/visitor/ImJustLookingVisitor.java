package com.example.visitor;

import com.example.shopItem.ShopItem;

import java.util.ArrayList;

public class ImJustLookingVisitor implements ShopVisitor {

    @Override
    public <T extends ArrayList<? extends ShopItem>> void visitShop(T shop) {
        for (ShopItem shopItem : shop) {
            System.out.printf("товар: %s, цена: %s%n", shopItem.getName(), shopItem.getPrice());
        }
    }
}
