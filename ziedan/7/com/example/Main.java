package com.example;

import com.example.factories.AppleGarden;
import com.example.factories.ElectronicsFactory;
import com.example.factories.FoodFactory;
import com.example.shops.*;
import com.example.visitor.ElectronicAddictedVisitor;
import com.example.visitor.ImJustLookingVisitor;
import com.example.visitor.RichVisitor;
import com.example.visitor.ShopVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ElectronicsShop eldorado = new ElectronicsShop();
        HyperMarket ozon = new HyperMarket();
        GroceryShop pyatorchka = new GroceryShop();

        ElectronicsFactory.fillShopWithElectronicGoods(eldorado);
        ElectronicsFactory.fillShopWithElectronicGoods(ozon);

        AppleStall myAppleStall = new AppleStall();
        AppleGarden.fillShopWithApples(myAppleStall);

        FoodFactory.fillShopWithFood(pyatorchka);
        FoodFactory.fillShopWithFood(ozon);

        List<ShopVisitor> visitors = new ArrayList<>();

        Random random = new Random();
        int countVisitors = random.nextInt(5) + 1;
        for (int i = 0; i < countVisitors; i++) {
            switch (random.nextInt(3)) {
                case 1:
                    visitors.add(new RichVisitor());
                    break;
                case 2:
                    visitors.add(new ElectronicAddictedVisitor());
                    break;
                default:
                    visitors.add(new ImJustLookingVisitor());
                    break;
            }
        }

        for (ShopVisitor visitor : visitors) {
            visitor.visitShop(eldorado);
            visitor.visitShop(ozon);
            visitor.visitShop(pyatorchka);
            visitor.visitShop(myAppleStall);
        }



    }
}
