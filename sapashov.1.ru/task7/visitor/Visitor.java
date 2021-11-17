package task7.visitor;

import task7.ShopItem;

import java.util.Collection;

public interface Visitor {
    void visitShop(Collection<? extends ShopItem> collection);
}
