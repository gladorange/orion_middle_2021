package task1.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Visitor {

    abstract public void visit(ArrayList<? extends ShopItem> shop);

    public static class ImJustLookingVisitor extends Visitor{

        @Override
        public  void visit(ArrayList<?extends ShopItem> shop) {
            shop.stream()
                    .forEach( a-> System.out.printf("Продукта %s имеет цену %s руб \n",a.getTitle(),a.getPrice())  );
        }
    }

    public static class ElectronicAddictedVisitor extends Visitor{
        @Override
        public  void visit(ArrayList<? extends ShopItem> shop) {
            shop.stream()
                    .filter( a-> a instanceof ShopItem.ElectronicItem)
                    .forEach( a-> System.out.printf("Продукта %s имеет цену %s руб \n",a.getTitle(),a.getPrice())  );
        }
    }

    public static class RichVisitor extends Visitor{
        @Override
        public void visit(ArrayList<? extends ShopItem> shop) {

            shop.removeIf( a -> {
                Boolean res = ((shop.indexOf(a)+1) % 2) == 0;
                if(res) System.out.printf("Куплен товар %s по цене %s \n",a.getTitle(),a.getPrice());
                return res;
            });


            System.out.printf("В магазине остались товары : %s \n",shop);
        }
    }
}
