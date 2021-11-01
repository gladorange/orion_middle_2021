package lection7.task1.factories;

import lection4.task1.spells.SpellsFabric;
import lection7.task1.Shop;
import lection7.task1.items.Apple;
import lection7.task1.items.FruitColor;
import lection7.task1.items.Refrigerator;
import lection7.task1.items.TV;

import java.util.Collection;
import java.util.Random;

/**
 AppleGarden - с методом fillShopWithApples. На вход передается коллекция(магазин) которую нужно заполнить.
 В эту коллекцию нужно добавить яблок разных цветов. Вывести на экран
 "В магазин добавлены яблоки: список_цветов"
 */
public class AppleGarden {
    static final Double MIN_APPLES_PRICE = 100.0;
    static final Double MAX_APPLES_PRICE = 200.0;
    static final Double MIN_APPLES_CALORIES = 50.0;
    static final Double MAX_APPLES_CALORIES = 65.0;
    static final int MIN_APPLES_LIFE = 30;
    static final int MAX_APPLES_LIFE = 90;
    static final String[] APPLES_NAMES = {"Богатырь","Малинка","Хани крисп","Ренет Симиренко",
            "Фуджи","Спартан","Карамелька","Чёрный принц","Гала","Голден","Антоновка"};

    public static void fillShopWithApples(Shop<? super Apple> items){
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        int i = (random.nextInt(APPLES_NAMES.length-1))+1;
        for (int j = 0; j < i; j++) {
            Apple apple = new Apple(APPLES_NAMES[random.nextInt(APPLES_NAMES.length)],
                    random.nextDouble()*(MAX_APPLES_PRICE-MIN_APPLES_PRICE)+MIN_APPLES_PRICE,
                    random.nextDouble()*(MAX_APPLES_CALORIES-MIN_APPLES_CALORIES)+MIN_APPLES_CALORIES,
                    random.nextInt(MAX_APPLES_LIFE-MIN_APPLES_LIFE)+MIN_APPLES_LIFE,
                    FruitColor.values()[random.nextInt(FruitColor.values().length)]);
            items.add(apple);
            str.append(apple);
            str.append("\n");
        }
        System.out.printf("В магазин (%s) добавлены яблоки:\n%s\n", items.getName(), str);

    }
}
