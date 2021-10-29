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

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<ShopItem> hypermarket = new ArrayList<>();
        List<ElectronicItem> electronicsStore = new ArrayList<>();
        List<FoodItem> groceryStore  = new ArrayList<>();
        List<Apple> appleStall  = new ArrayList<>();

        ElectronicFactory.fillShopWithElectronicGoods(hypermarket);
        ElectronicFactory.fillShopWithElectronicGoods(electronicsStore);

        AppleGarden.fillShopWithApples(hypermarket);
        AppleGarden.fillShopWithApples(groceryStore);
        AppleGarden.fillShopWithApples(appleStall);

        FoodFactory.fillShopWithFood(hypermarket);
        FoodFactory.fillShopWithFood(groceryStore);

    }
}
