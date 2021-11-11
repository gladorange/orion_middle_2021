package task1.classes;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ElectronicFactory {

    static List< ShopItem.ElectronicItem > elProducts = new ArrayList<ShopItem.ElectronicItem>();

    static {
        elProducts.add(new TV("Samsung QE50Q67AAU",15999.00,4200.0, 12) );
        elProducts.add(new TV("LG 43UN68006LA",49999.0,4040.0, 16) );
        elProducts.add(new TV("Haier 32 Smart TV BX ",41999.00,4330.0, 13) );
        elProducts.add(new TV("Novex NWX-24H121MSY ",45999.00,4068.0, 12) );
        elProducts.add(new TV("Toshiba 32L5069 ",18999.00,4063.0, 16) );
        elProducts.add(new Refrigerator("Hotpoint-Ariston HTS 5200 W ",27999.90,5040.0, 19) );
        elProducts.add(new Refrigerator("Indesit ITS 5200 W ",24799.0,7400.0, 12) );
        elProducts.add(new Refrigerator("LG DoorCooling+ GA-B509CBTL  ",43999.00,3040.0, 32) );
        elProducts.add(new Refrigerator("Haier C2F636CWFD",45999.00,9400.0, 12) );
        elProducts.add(new Refrigerator("LG DoorCooling+ GA-B459SMUM",42999.00,2000.0, 56) );
    }

    public static  <T extends Collection<? super ShopItem.ElectronicItem>> void fillShopWithElectronicGoods(T shop){
        Integer rand ;
        ShopItem.ElectronicItem product ;

        for (int i = 0 ; i < 6; i++){
            rand = ThreadLocalRandom.current().nextInt(0,elProducts.size());
            product = elProducts.get(rand);
            shop.add( product );
        }
        System.out.printf("В магазин добавлены товары: %s \n",shop);

    }
}
