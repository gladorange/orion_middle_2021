package visitors;

import items.ShopItem;

import java.util.Collection;

public abstract class BuyerVisitor implements ShopVisitor {
    @Override
    public abstract void visitShop(Collection<? extends ShopItem> shop);

    protected void buy(Collection<? extends ShopItem> shop, ShopItem item){
        if(item == null || !shop.contains(item)){
            return;
        }
        System.out.printf("%s куплен по цене %s\n", item.getName(), item.getPrice());
        shop.remove(item);
    }
}
