package task7.visitor;

import task7.ShopItem;

import java.util.ArrayList;
import java.util.Collection;

public class RichVisitor implements Visitor{
    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {

    }

    public void buyEverySecondItem(Collection<? extends ShopItem> collection) {
        ArrayList<ShopItem> itemList = new ArrayList<>(collection);
        for (int i = 0; i < itemList.size() -1 ; i++) {
            if (i % 2 == 0) {
                itemList.remove(itemList.get(i));
                System.out.println("Item sold: " + itemList.get(i));
            }
        }
    }

}
