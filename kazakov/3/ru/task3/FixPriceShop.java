/*
Задание 3. счастливые часы

        Создайте класс FixPriceShop - сеть магазинов, которая продает товары по одной цене.
        В классе создайте поле items - массив товаров (товар - это просто название, тип String)
        Во всех магазинах - одинаковая цена на все товары, например, все магазины продают товары по 49.
        Во всех магазинах действует акции "счастливый час" - час (от 0 до 23), когда действует скидка 50%
        В каждом магазине "счастливый час" разный. , т.е. какой-то магазин продает со скидкой в 11, а другой в 23.

*/

package ru.task3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FixPriceShop {
    public static final int FIX_PRICE_MIN_PRICE = 25;  //  some fix price constants
    public static final int FIX_PRICE_MAX_PRICE = 55;
    /*  - для хранение единой цены используйте статическую переменную.
     * Значение можете задать константой или использовать класс Random() для заполнения случайным числом.
     */
    static final int FIX_PRICE = ThreadLocalRandom.current().nextInt(FIX_PRICE_MIN_PRICE, FIX_PRICE_MAX_PRICE + 1);   //  UNIFIED fixPrices within rand.range


    final int HappyHour = ThreadLocalRandom.current().nextInt(0, (int)Duration.ofDays(1).toHours());   //  generated random happy hour
    List <String> items = new ArrayList<>();

	/**
     *  - Для заполнения магазина товарами используйте конструктор.
     * Можете передать список в магазин или использовать конструктор без параметров и
     * генерировать список внутри конструктора.
     * <p>
     * Constructor: fill FixPriceShop with: 1.arbitrary 2.unique items from an array, which is passed as parameter:
     */
    FixPriceShop(String [] itemsArr) {
        List <String> itemsToFill = new ArrayList<>();
        int randItemsInShop = ThreadLocalRandom.current().nextInt(0, itemsArr.length);

        System.out.printf("constructor: будет товаров: %dшт.\n", randItemsInShop);
        for (int i = 0; i < randItemsInShop; i++) {
            String s = itemsArr[ThreadLocalRandom.current().nextInt(0, itemsArr.length)];
            if (!itemsToFill.contains(s)) {   //  fiil shop with unique items
                System.out.printf("constructor: добавляем товар: <%s>\n", s);
                itemsToFill.add(s);
            }
        }
        this.items.addAll(itemsToFill);
        System.out.printf("constructor 2: %s, всего: %dшт.\n", Collections.singletonList(items), this.items.size());
    }

    /**
    - В классе FixPriceShop определите метод  int checkItemPrice(String item, int hour) -
     * <p>
    первый аргумент - это название товара, который покупатель собирается купить,
    второй аргумент - время покупки.
    Метод должен возвращать цену.
    Если время покупки совпадает со счастливым часом - то должна быть учтена скидка 50%.
    Если указанный товар не обнаружен - то метод должен вернуть -1.
     */
    int checkItemPrice(String item, int hour) {
        int indx = items.indexOf(item);
        if (indx < 0)
            return -1;
        return (hour == HappyHour) ? FIX_PRICE / 2 : FIX_PRICE;
    }

    /**
        - В классе FixPriceShop определите метод String[] getItems() - который возвращает массив
    доступных товаров в магазине.
     * <p>
    В возвращенном массиве не должно быть null элементов.
     * @return массив доступных товаров в магазине: String []
     */
    String [] getItems() {
        //  1. extinguish null items in list:
        while(items.remove(null)) { }
        //  2. return items as array of Stings:
        String[] itemArray = new String[items.size()];
        itemArray = items.toArray(itemArray);
        return itemArray;
    }

    /**
        - В классе FixPriceShop определите метод void buyItem(String item, int hour) -
     * <p>
    который выводит на экран надпись "товар <> продан по цене <>".
    Цена выводится с учетом времени. После этого, из массива товаров купленный товар должен быть удален.
    Если такого товара нет - выведите на экран "товар <> не обнаружен"
     * @author Kazakov Marat 2021
     */
    void buyItem(String item, int hour) {

        int price = checkItemPrice(item,  hour);
        if (price == -1) {
            System.out.printf("товар <%s> не обнаружен\n", item);
            return;
        }
        System.out.printf("товар <%s> продан по цене <%d> в %dчас.\n", item, price, hour);
        //  delete bought item:
        items.remove(item);
    }
}
