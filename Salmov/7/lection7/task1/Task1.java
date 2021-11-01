package lection7.task1;
//Домашнее задание к лекции 7
//Магазинное обобщение
//Салмов Евгений

import lection7.task1.factories.AppleGarden;
import lection7.task1.factories.ElectronicFactory;
import lection7.task1.factories.FoodFactory;
import lection7.task1.items.Apple;
import lection7.task1.items.ElectronicItem;
import lection7.task1.items.FoodItem;
import lection7.task1.items.ShopItem;
import lection7.task1.visitors.ElectronicAddictedVisitor;
import lection7.task1.visitors.ImJustLookingVisitor;
import lection7.task1.visitors.RichVisitor;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        Shop<ShopItem> hypermarket = new Shop<>("Гипермаркет");
        Shop<ElectronicItem> electronicsStore = new Shop<>("Магазин электронной продукции");
        Shop<FoodItem> groceryStore  = new Shop<>("Продуктовый магазин");
        Shop<Apple> appleStall  = new Shop<>("Ларёк с яблоками");

        System.out.println("Добавим электронные товары в гипермаркет и магазин электронной продукции!");
        ElectronicFactory.fillShopWithElectronicGoods(hypermarket);
        ElectronicFactory.fillShopWithElectronicGoods(electronicsStore);

        System.out.println("Добавим яблоки в гипермаркет, продуктовый магазин и ларёк с яблоками!");
        AppleGarden.fillShopWithApples(hypermarket);
        AppleGarden.fillShopWithApples(groceryStore);
        AppleGarden.fillShopWithApples(appleStall);

        System.out.println("Добавим продукты (яблоки и хлеб) в гипермаркет и продуктовый магазин!");
        FoodFactory.fillShopWithFood(hypermarket);
        FoodFactory.fillShopWithFood(groceryStore);

        List<Shop<? extends ShopItem>> knownShops = new ArrayList<>();
        knownShops.add(hypermarket);
        knownShops.add(electronicsStore);
        knownShops.add(groceryStore);
        knownShops.add(appleStall);

        ImJustLookingVisitor ben = new ImJustLookingVisitor();
        ElectronicAddictedVisitor dennis = new ElectronicAddictedVisitor();
        RichVisitor william = new RichVisitor();
        for (Shop<? extends ShopItem> shop: knownShops) {
            dennis.visitShop(shop);
            william.visitShop(shop);
            ben.visitShop(shop);
        }
    }
}
