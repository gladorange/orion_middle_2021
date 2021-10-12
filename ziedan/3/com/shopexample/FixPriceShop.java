package com.shopexample;

import java.util.Random;

public class FixPriceShop {
    private static final int FIXED_PRICE = 49;
    private String[] items;
    private final int happyHour;

    public FixPriceShop() {
        this.items = generateItems((new Random()).nextInt(15) + 5);
        happyHour = (new Random()).nextInt(23);
    }

    private String[] generateItems(int count) {
        String[] items = {
                "Колготки женские, Conte, 20 DEN, в ассортименте",
                "Наволочка декоративная, 40х40 см",
                "Кашпо садовое, Greenart, 21 см, в ассортименте",
                "Блокнот на цветной спирали, А6, 80 листов",
                "Игрушка \"Машина для куклы со светом\", Play the Game,… в ассортименте",
                "Шарф-хомут, Lady collection, в ассортименте, 29х60 см",
                "Бумага для упаковки подарка, Снежное… кружево, 70х100 см, в ассортименте",
                "Набор шариковых ручек, BIC, 5 шт.",
                "Влажные салфетки Cotte для интимной гигиены, 40 шт",
                "Рулет бисквитный с джемом \"Dolche Ame\", 145 г, в… ассортименте",
                "Игровой набор \"Машинки\", Play the Game, в… ассортименте",
                "Освежитель воздуха Air Freshener сменный, 250 мл",
                "Пастила ванильная, Тимоша, 200 г",
                "Очищающие влажные салфетки с углём, Olea… Urban, 60 шт., в ассортименте",
                "Корзина кухонная на колесиках, в ассортименте",
                "Игрушка велосипед для кукол, Play the Game, в… ассортименте",
                "Шоколадный батончик Snickers Crisper, 60 г",
                "Туалетное мыло, Magic Drive, 90 г, в ассортименте",
                "Набор эластичных крышек, O'Kitchen, в ассортименте",
                "Игровой набор \"Детский пазл\", Play the Game, в… ассортименте",
                "Растворимый чай \"Матча Латте\", Teaory, 8… пакетиков, 128 г",
        };

        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[i];
        }
        return result;
    }

    public void buyItem(String item, int hour) {
        int price = checkItemPrice(item, hour);
        if (price == -1) {
            System.out.printf("Товар <%s> не обнаружен\n", item);
        } else {
            removeItem(item);
            System.out.printf("Товар <%s> продан по цене %s\n", item, price);
        }
    }

    private void removeItem(String item) {
        String[] newItems = new String[items.length - 1];
        boolean removed = false;
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            String currentItem = items[i];
            if (!currentItem.equals(item) || removed) {
                newItems[j] = currentItem;
                j++;
            } else {
                removed = true;
            }
        }
        items = newItems;
    }

    public int checkItemPrice(String item, int hour) {
        if (indexOfItem(item) > -1) {
            return isHappyHour(hour) ? (int) (FIXED_PRICE * 0.5) : FIXED_PRICE;
        } else {
            return -1;
        }
    }

    private int indexOfItem(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isHappyHour(int hour) {
        return hour == happyHour;
    }

    public String[] getItems() {
        return items;
    }

}
