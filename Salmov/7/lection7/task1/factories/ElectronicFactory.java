package lection7.task1.factories;

import lection4.task1.spells.Spell;
import lection7.task1.Shop;
import lection7.task1.Task1;
import lection7.task1.items.ElectronicItem;
import lection7.task1.items.Refrigerator;
import lection7.task1.items.TV;

import java.util.Collection;
import java.util.Random;

/**
 ElectronicFabric - с методом fillShopWithElectronicGoods. На вход передается коллекция(магазин) которую нужно заполнить.
 В эту коллекцию нужно добавить несколько холодильников или телевизоров с разными свойствами и вывести на экран
 "В магазин добавлена электроника: список_товаров"
 */
public class ElectronicFactory {
    static final int MIN_TV_CNT = 1;
    static final int MAX_TV_CNT = 5;
    static final Double MIN_TV_PRICE = 10000.0;
    static final Double MAX_TV_PRICE = 350000.0;
    static final Double MIN_TV_POWER = 500.0;
    static final Double MAX_TV_POWER = 2000.0;
    static final Double MIN_TV_VOLUME = 8.0;
    static final Double MAX_TV_VOLUME = 128.0;
    static final String[] TV_NAMES = {"Samsung","LG","Sony","Xiaomi",
            "Hyundai","Starwind","Philips","SkyLine"};

    static final int MIN_FRIDGE_CNT = 1;
    static final int MAX_FRIDGE_CNT = 5;
    static final Double MIN_FRIDGE_PRICE = 20000.0;
    static final Double MAX_FRIDGE_PRICE = 250000.0;
    static final Double MIN_FRIDGE_POWER = 500.0;
    static final Double MAX_FRIDGE_POWER = 4000.0;
    static final int MIN_FRIDGE_VOLUME = 100;
    static final int MAX_FRIDGE_VOLUME = 400;
    static final String[] FRIDGE_NAMES = {"Samsung","LG","ATLANT","BEKO",
            "Hyundai","Ariston","Stinol","Indesit","BOSCH","ELECTROLUX"};

    public static void fillShopWithElectronicGoods(Shop<? super ElectronicItem> items){
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        int i = (random.nextInt(MAX_TV_CNT-MIN_TV_CNT))+MIN_TV_CNT;
        for (int j = 0; j < i; j++) {
            TV tv = new TV(TV_NAMES[random.nextInt(TV_NAMES.length)],
                    random.nextDouble()*(MAX_TV_PRICE-MIN_TV_PRICE)+MIN_TV_PRICE,
                    random.nextDouble()*(MAX_TV_POWER-MIN_TV_POWER)+MIN_TV_POWER,
                    random.nextDouble()*(MAX_TV_VOLUME-MIN_TV_VOLUME)+MIN_TV_VOLUME);
            items.add(tv);
            str.append(tv);
            str.append("\n");
        }
        i = (random.nextInt(MAX_FRIDGE_CNT-MIN_FRIDGE_CNT))+MIN_FRIDGE_CNT;
        for (int j = 0; j < i; j++) {
            Refrigerator fridge = new Refrigerator(FRIDGE_NAMES[random.nextInt(FRIDGE_NAMES.length)],
                    random.nextDouble()*(MAX_FRIDGE_PRICE-MIN_FRIDGE_PRICE)+MIN_FRIDGE_PRICE,
                    random.nextDouble()*(MAX_FRIDGE_POWER-MIN_FRIDGE_POWER)+MIN_FRIDGE_POWER,
                    random.nextInt(MAX_FRIDGE_VOLUME-MIN_FRIDGE_VOLUME)+MIN_FRIDGE_VOLUME);
            items.add(fridge);
            str.append(fridge);
            str.append("\n");
        }
        System.out.printf("В магазин (%s) добавлена электроника:\n%s\n", items.getName(), str);
    }

}
