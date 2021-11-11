package task1;

import task1.classes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class StoreGeneralization {

    public static void main(String[] args) {

        ArrayList<ShopItem> hyperMarket = new ArrayList<ShopItem>();
        ArrayList<ShopItem.ElectronicItem> electronicMarket = new ArrayList<ShopItem.ElectronicItem>();
        ArrayList<ShopItem.FoodItem> foodMarket = new ArrayList<ShopItem.FoodItem>();
        ArrayList<Apple> appleKiosk = new ArrayList<Apple>();

        System.out.print("Заполняем гипермаркет ElectronicFactory\n");
        ElectronicFactory.fillShopWithElectronicGoods( hyperMarket ) ;
        System.out.print("Заполняем магазин электроники ElectronicFactory\n");
        ElectronicFactory.fillShopWithElectronicGoods( electronicMarket ) ;

        System.out.print("Заполняем гипермаркет AppleGarden\n");
        AppleGarden.fillShopWithApples(hyperMarket);
        System.out.print("Заполняем продуктовый магазин FoodMarket\n");
        AppleGarden.fillShopWithApples(foodMarket);
        System.out.print("Заполняем Киоск AppleGarden\n");
        AppleGarden.fillShopWithApples( (ArrayList)appleKiosk);

        System.out.print("Заполняем гипермаркет FoodFactory\n");
        FoodFactory.fillShopWithFood(hyperMarket);
        System.out.print("Заполняем продуктовый магазин FoodFactory\n");
        FoodFactory.fillShopWithFood(foodMarket);


        Visitor justLookingVisitor = new Visitor.ImJustLookingVisitor();
        System.out.print("--\nПосетитель justLookingVisitor посещает магазин HyperMarket\n");
        justLookingVisitor.visit(hyperMarket);
        System.out.print("--\nПосетитель justLookingVisitor посещает магазин ElectronicMarket\n");
        justLookingVisitor.visit(electronicMarket);
        System.out.print("--\nПосетитель justLookingVisitor посещает магазин FoodMarket\n");
        justLookingVisitor.visit(foodMarket);
        System.out.print("--\nПосетитель justLookingVisitor посещает магазин AppleKiosk\n");
        justLookingVisitor.visit(appleKiosk);

        Visitor electronicAddictedVisitor = new Visitor.ElectronicAddictedVisitor();
        System.out.print("--\nПосетитель ElectronicAddictedVisitor посещает магазин HyperMarket\n");
        electronicAddictedVisitor.visit( hyperMarket );
        System.out.print("--\nПосетитель ElectronicAddictedVisitor посещает магазин ElectronicMarket\n");
        electronicAddictedVisitor.visit( electronicMarket );
        System.out.print("--\nПосетитель ElectronicAddictedVisitor посещает магазин FoodMarket\n");
        electronicAddictedVisitor.visit( foodMarket );
        System.out.print("--\nПосетитель ElectronicAddictedVisitor посещает магазин AppleKiosk\n");
        electronicAddictedVisitor.visit( appleKiosk );


        Visitor richVisitor = new Visitor.RichVisitor();
        System.out.print("--\nПосетитель RichVisitor посещает магазин HyperMarket\n");
        richVisitor.visit(hyperMarket);
        System.out.print("--\nПосетитель RichVisitor посещает магазин electronicMarket\n");
        richVisitor.visit(electronicMarket);
        System.out.print("--\nПосетитель RichVisitor посещает магазин foodMarket\n");
        richVisitor.visit(foodMarket);
        System.out.print("--\nПосетитель RichVisitor посещает магазин appleKiosk\n");
        richVisitor.visit(appleKiosk);

    }
}
