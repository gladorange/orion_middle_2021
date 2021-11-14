package task7.visitor;

import task7.ShopItem;

import java.util.Collection;

public class ImJustLookingVisitor implements Visitor {

    @Override
    public void visitShop(Collection<? extends ShopItem> collection) {

    }

    public void justLook(Collection<? extends ShopItem> collection) {
        collection.forEach(System.out::println);
    }

}
