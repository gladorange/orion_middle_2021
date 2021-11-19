package task7.electricitems;

import task7.Randomizer;
import task7.ShopItem;

import java.util.Collection;

public class ElectronicFabric {

//    public Collection<ElectronicItem> fillShopWithElectronicGoods(Collection<ElectronicItem> items) {
    public void fillShopWithElectronicGoods(Collection<? super ElectronicItem> items) {
        int randomInt = Randomizer.generate(5 , 10);
        for(int i = 0; i < randomInt; i++){
            if(i % 2 == 0){
                items.add(new TV(randomInt));
            } else {
                items.add(new Refrigerator(randomInt));
            }
        }

        System.out.println("Items added to the Store");
        System.out.println(items.size());
        items.forEach(System.out::println);
    }



}
