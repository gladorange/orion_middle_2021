package lection7.task1.factories;

import lection7.task1.Shop;
import lection7.task1.items.Apple;
import lection7.task1.items.Bread;
import lection7.task1.items.FoodItem;
import lection7.task1.items.FruitColor;

import java.util.Collection;
import java.util.Random;

/**
 FoodFactory - с методом fillShopWithFood. На вход передается коллекция(магазин) которую нужно заполнить.
 В эту коллекцию нужно добавить немного яблок и немного хлеба. Вывести на экран
 "В магазин добавлены яблоки: список_цветов и хлеба, общим весом: вес_в_граммах"
 */
public class FoodFactory {
    static final Double MIN_BREAD_PRICE = 50.0;
    static final Double MAX_BREAD_PRICE = 250.0;
    static final Double MIN_BREAD_CALORIES = 200.0;
    static final Double MAX_BREAD_CALORIES = 300.0;
    static final int MIN_BREAD_LIFE = 3;
    static final int MAX_BREAD_LIFE = 10;
    static final int MIN_BREAD_WEIGHT = 150;
    static final int MAX_BREAD_WEIGHT = 1000;
    static final String[] BREAD_NAMES = {"Белый","Горчичный","Чёрный","Бородинский",
            "Пикантный","Ржаной","Домашний","Бездрожжевой","Пшеничный","Гречневый","Семейный"};

    public static void fillShopWithFood (Shop<? super FoodItem> items){
        AppleGarden.fillShopWithApples(items);
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        int i = (random.nextInt(BREAD_NAMES.length-1))+1;
        int totalWeight = 0;
        for (int j = 0; j < i; j++) {
            Bread bread = new Bread(BREAD_NAMES[random.nextInt(BREAD_NAMES.length)],
                    random.nextDouble()*(MAX_BREAD_PRICE-MIN_BREAD_PRICE)+MIN_BREAD_PRICE,
                    random.nextDouble()*(MAX_BREAD_CALORIES-MIN_BREAD_CALORIES)+MIN_BREAD_CALORIES,
                    random.nextInt(MAX_BREAD_LIFE-MIN_BREAD_LIFE)+MIN_BREAD_LIFE,
                    random.nextInt(MAX_BREAD_WEIGHT-MIN_BREAD_WEIGHT)+MIN_BREAD_WEIGHT);
            items.add(bread);
            str.append(bread);
            str.append("\n");
            totalWeight += bread.getWeight();
        }
        System.out.printf("В магазин (%s) добавлен хлеб:\n%s", items.getName(), str);
        System.out.printf("Общий вес добавленного хлеба: %s грамм\n\n", totalWeight);
    }
}
