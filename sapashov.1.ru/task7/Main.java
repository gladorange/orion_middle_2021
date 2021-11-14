package task7;

import task7.electricitems.ElectronicFabric;
import task7.fooditems.Apple;
import task7.electricitems.ElectronicItem;
import task7.fooditems.AppleGarden;
import task7.fooditems.FoodFactory;
import task7.fooditems.FoodItem;
import task7.visitor.*;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<ShopItem> hyperMarket = new ArrayList<>();
        Collection<ElectronicItem> electricItemsStore = new ArrayList<>();
        Collection<FoodItem> foodStore = new ArrayList<>();
        Collection<Apple> sellPoint = new ArrayList<>();

        // fill with electric items
        ElectronicFabric electronicFabric = new ElectronicFabric();
        electronicFabric.fillShopWithElectronicGoods(hyperMarket);
        electronicFabric.fillShopWithElectronicGoods(electricItemsStore);


        // fill with apples
        AppleGarden appleGarden = new AppleGarden();
        appleGarden.fillShopWithApples(foodStore);
        appleGarden.fillShopWithApples(sellPoint);
        appleGarden.fillShopWithApples(hyperMarket);

        // fill with food
        FoodFactory foodFactory = new FoodFactory();
        foodFactory.fillShopWithFood(foodStore);
        foodFactory.fillShopWithFood(hyperMarket);

        ElectronicAddictedVisitor electronicAddictedVisitor = new ElectronicAddictedVisitor();
        electronicAddictedVisitor.buyElectricItemWithHighestPrice(hyperMarket);
        electronicAddictedVisitor.buyElectricItemWithHighestPrice(electricItemsStore);

        ImJustLookingVisitor imJustLookingVisitor = new ImJustLookingVisitor();
        imJustLookingVisitor.justLook(hyperMarket);
        imJustLookingVisitor.justLook(electricItemsStore);

        RichVisitor richVisitor = new RichVisitor();
        richVisitor.buyEverySecondItem(hyperMarket);
        richVisitor.buyEverySecondItem(electricItemsStore);
        richVisitor.buyEverySecondItem(sellPoint);





    }
}
