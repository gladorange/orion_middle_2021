import items.ShopItem;
import items.electronic.ElectronicItem;
import items.factories.AppleGarden;
import items.factories.ElectronicFactory;
import items.factories.FoodFactory;
import items.foods.Apple;
import items.foods.FoodItem;
import visitors.ElectronicAddictedVisitor;
import visitors.ImJustLookingVisitor;
import visitors.RichVisitor;
import visitors.ShopVisitor;

import java.util.*;

public class Main7 {
    public static void main(String[] args) {

        Map<String, Collection<? extends ShopItem>> shops = new HashMap<>();

        Collection<ShopItem> hypermarket =  new LinkedList<>();
        Collection<ElectronicItem> electronicShop = new LinkedList<>();
        Collection<FoodItem> foodShop = new LinkedList<>();
        Collection<Apple> appleStore =  new LinkedList<>();

        shops.put("Гипермаркет", hypermarket);
        shops.put("Электромагазин", electronicShop);
        shops.put("Продуктовый", foodShop);
        shops.put("Яблочный ларек", appleStore);

        ElectronicFactory electronicFactory = new ElectronicFactory();
        electronicFactory.fillShopWithElectronicGoods(hypermarket);
        electronicFactory.fillShopWithElectronicGoods(electronicShop);

        AppleGarden appleGarden = new AppleGarden();
        appleGarden.fillShopWithApples(hypermarket);
        appleGarden.fillShopWithApples(foodShop);
        appleGarden.fillShopWithApples(appleStore);

        FoodFactory foodFactory = new FoodFactory();
        foodFactory.fillShopWithFood(hypermarket);
        foodFactory.fillShopWithFood(foodShop);

        visitorGoShopping(new ImJustLookingVisitor(), shops);
        visitorGoShopping(new ElectronicAddictedVisitor(), shops);
        visitorGoShopping(new RichVisitor(), shops);

    }

    private static void visitorGoShopping(ShopVisitor visitor, Map<String, Collection<? extends ShopItem>> shops){
        for(String key: shops.keySet()){
            System.out.printf("%s пошел в магазин: %s\n", visitor.getClass(), key);
            visitor.visitShop(shops.get(key));
            System.out.println("Посетитель покинул магазин.");
        }
    }
}
