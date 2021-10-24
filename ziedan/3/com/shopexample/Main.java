package com.shopexample;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        FixPriceShop[] shops = new FixPriceShop[3];

        for (int i = 0; i < 3; i++) {
            shops[i] = new FixPriceShop();
        }

        for (FixPriceShop shop : shops) {
            String[] items = shop.getItems();
            String item = items[(new Random()).nextInt(items.length - 1)];
            int minPrice = -1;
            int happyHour = -1;
            for (int hour = 0; hour <= 23; hour++) {
                int price = shop.checkItemPrice(item, hour);
                if (minPrice == -1) {
                    minPrice = price;
                } else if (price < minPrice){
                    minPrice = price;
                    happyHour = hour;
                }
            }
            shop.buyItem(item, happyHour);
            shop.buyItem(item, happyHour); // just for checking if item is already bought
        }
    }
}
