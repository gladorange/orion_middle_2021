package ru.task7;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        //  Гипермаркет - хранит любые товары. Collection<ShopItem>
        Collection<ShopItem> hyperMarket = new ArrayList<>();
        //  - Магазин электронной продукции - торгует только электроникой. Collection<ElectronicItem>
        Collection<ElectronicItem> electronicsStore = new ArrayList<>();
        //  - Продуктовый магазин - торгует продуктами Collection<FoodItem>
        Collection<FoodItem> foodStore = new ArrayList<>();
        //  - Ларек с яблоками у дома - торгует только яблоками.  Collection<Apple>
        ArrayList<Apple> appleShop = new ArrayList<>();

        /*
        Заполните следующие магазины товарами, используя AppleGarden:
        - Продуктовый магазин
         */
        AppleGarden.fillShopWithApples(foodStore);
        //  - Ларек с яблоками у дома
        AppleGarden.fillShopWithApples(appleShop);
        //  - Гипермаркет
        AppleGarden.fillShopWithApples(hyperMarket);
        //Обратите внимание, что если попытаться вызвать
        //AppleGarden.fillShopWithApples(магазин_электроники) - ошибка компиляции:
//        AppleGarden.fillShopWithApples(electronicsStore) ;

        /*
        Заполните следующие магазины товарами, используя ElectronicFabric:
        - Гипермаркет
        */
        ElectronicFabric.fillShopWithElectronicGoods(hyperMarket);
        //  -Магазин электронной продукции
        ElectronicFabric.fillShopWithElectronicGoods(electronicsStore);
        //Обратите внимание, что если попытаться вызвать
        //ElectronicFabric.fillShopWithElectronicGoods(магазин_с_яблоками или продуктовый_магазин) - ошибка компиляции
//        ElectronicFabric.fillShopWithElectronicGoods(foodStore);

        /*
        Заполните следующие магазины товарами, используя FoodFactory:
        - Продуктовый магазин
                - Гипермаркет
         */
        FoodFactory.fillShopWithFood(foodStore);
        FoodFactory.fillShopWithFood(hyperMarket);
        /*
        Обратите внимание, что если попытаться вызвать
        FoodFactory.fillShopWithFood(магазин_электроники) - ошибка компиляции
        FoodFactory.fillShopWithFood(ларек_с_яблоками) - ошибка компиляции (Владелец ларька очень расстроится, если под видом яблок купят хлеб)
         */
//        FoodFactory.fillShopWithFood(electronicsStore);
//        FoodFactory.fillShopWithFood(appleShop);

        //  Создайте трех посетителей разных классов и пусть они погуляют по всем магазинам.
        Collection<ShopVisitor> shopVisitors = new ArrayList<>();
        shopVisitors.add(new ImJustLookingVisitor());
        shopVisitors.add(new ElectronicsAddictVisitor());
        shopVisitors.add(new RichVisitor());
        for (ShopVisitor sv : shopVisitors) {
            sv.visitShop(hyperMarket);
            sv.visitShop(electronicsStore);
            sv.visitShop(foodStore);
            sv.visitShop(appleShop);
        }
    }
}
