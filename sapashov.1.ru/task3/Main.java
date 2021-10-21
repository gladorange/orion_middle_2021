package task3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        FixPriceShop shop1 = new FixPriceShop(23);
        FixPriceShop shop2 = new FixPriceShop(3);
        FixPriceShop shop3 = new FixPriceShop(12);

        String[] shopArray1 = new String[10];
        String[] shopArray2 = new String[10];
        String[] shopArray3 = new String[10];

        for(int i = 0; i < shopArray1.length; i++) {
            shopArray1[i] = "goods1" + i;
            shopArray2[i] = "goods2" + i;
            shopArray3[i] = "goods3" + i;
        }
        shop1.setItems(shopArray1);
        shop2.setItems(shopArray2);
        shop3.setItems(shopArray3);

        shop1.buyItem(shop1.getItems()[getRandomIntInRange(0, 9)], getTheBestPrice(shop1));
        shop2.buyItem(shop2.getItems()[getRandomIntInRange(0, 9)], getTheBestPrice(shop2));
        shop3.buyItem(shop3.getItems()[getRandomIntInRange(0, 9)], getTheBestPrice(shop3));

        System.out.println(Arrays.toString(shop1.getItems()));
        System.out.println(Arrays.toString(shop2.getItems()));
        System.out.println(Arrays.toString(shop3.getItems()));

    }

    private static int getRandomIntInRange(int min, int max){
        return  ThreadLocalRandom.current().nextInt(min, max);
    }

    private static int getTheBestPrice(FixPriceShop shop) {
       return shop.getHappyHour();
    }
}
