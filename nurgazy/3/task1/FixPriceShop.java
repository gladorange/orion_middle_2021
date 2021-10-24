package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FixPriceShop {
    private String[] items;
    private int luckyHour;
    final static private int price = 100;


    int checkItemPrice(String item, int hour) {
        int currentPrice = ((hour == luckyHour) ? price/2 : price);
        for (String s : items) {
            if (item.equals(s)){
                return currentPrice;
            }
        }
        return -1;
    }

    String[] getItems() {
        List<String> tempList = new ArrayList<>();
        for (String s : items) {
            if (s != null) {
                tempList.add(s);
            }
        }
        return tempList.toArray(new String[tempList.size()]);
    }

    void buyItem(String item, int hour) {
        int currentPrice = ((hour == luckyHour) ? price/2 : price);
        for (int i = 0; i < items.length; i++) {
            if (item.equals(items[i])) {
                System.out.println("товар " + item + " продан по цене " + currentPrice);
                items[i] = null;
                return;
            }
        }
        System.out.println("товар " + item + " не обнаружен");
    }


    public FixPriceShop(String[] items) {
        this.items = items;
    }

    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop(new String[]{"Apple", "Orange", "Banana", "Lemon", "Peach", "Mango"});
        shop1.luckyHour = 12;

        FixPriceShop shop2 = new FixPriceShop(new String[]{"Phone", "TV", "Radio", "Fridge", "Kettle"});
        shop2.luckyHour = 10;

        FixPriceShop shop3 = new FixPriceShop(new String[]{"Snickers", "Mars", "Bounty", "Twicks", "Nesquik"});
        shop3.luckyHour = 18;

        String[] itemsFromShop1 = shop1.items;

        Random random = new Random();

        String currentItem1 = itemsFromShop1[random.nextInt(itemsFromShop1.length)];

        for (int i = 0; i < 24; i++) {
            if (shop1.checkItemPrice(currentItem1, i) == shop1.checkItemPrice(currentItem1, shop1.luckyHour)) {
                System.out.println("Оптимальное время для покупки: " + i);
                shop1.buyItem(currentItem1, i);
                break;
            }
        }

        shop1.buyItem(currentItem1, 1);
    }
}
