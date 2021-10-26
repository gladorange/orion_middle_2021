package com.example.visitor;

import com.example.shopItem.ElectronicItem;
import com.example.shopItem.ShopItem;

import java.util.ArrayList;

public class ElectronicAddictedVisitor implements ShopVisitor {

    @Override
    public <T extends ArrayList<? extends ShopItem>> void visitShop(T shop) {
        ElectronicItem wantedItem = null;
        for (ShopItem shopItem : shop) {
            if (shopItem instanceof ElectronicItem) {
                System.out.printf("товар: %s, цена: %s%n", shopItem.getName(), shopItem.getPrice());
                if (wantedItem == null || ((ElectronicItem) shopItem).getPowerConsumption() > wantedItem.getPowerConsumption()) {
                    wantedItem = (ElectronicItem) shopItem;
                }
            }

        }
        if (wantedItem != null) {
            buyItemFromShop(wantedItem, shop);
        }
    }

}
