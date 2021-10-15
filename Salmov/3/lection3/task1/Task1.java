package lection3.task1;
//Домашнее задание к лекции 3
//Счастливые часы
//Салмов Евгений

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static final int SHOPS_COUNT = 3;

    public static void main(String[] args) {
        FixPriceShop[] shops = new FixPriceShop[SHOPS_COUNT];
        for (int i = 0; i < shops.length; i++) {
            shops[i] = new FixPriceShop();
            System.out.printf("Счастливый час в %s магазине: %s\n", i+1, shops[i].getHappyHour());
            String[] itemsInShop = shops[i].getItems();
            System.out.printf("Товары в %s магазине: %s\n", i+1, Arrays.toString(itemsInShop));
            Random random = new Random();
            String selectedItem = itemsInShop[ random.nextInt(itemsInShop.length) ];
            System.out.println("Выбрали товар: "+selectedItem);
            int minimumPrice = shops[i].checkItemPrice(selectedItem,0);
            int foundHappyHour = 0;
            for(int j=1; j<24; j++){
                int priceForHour = shops[i].checkItemPrice(selectedItem,j);
                if(minimumPrice<priceForHour){
                    break;
                }
                minimumPrice = priceForHour;
                foundHappyHour = j;
            }
            System.out.println("Найденный счастливый час: "+foundHappyHour);
            System.out.println("Пробуем купить первый раз");
            shops[i].buyItem(selectedItem,foundHappyHour);
            System.out.println("Пробуем купить второй раз");
            shops[i].buyItem(selectedItem,foundHappyHour);
            System.out.println();
        }

    }
}
