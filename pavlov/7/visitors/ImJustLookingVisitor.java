package visitors;

import items.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements ShopVisitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        for(ShopItem item: shop){
            System.out.println(item.getDescription());
        }
    }
}
