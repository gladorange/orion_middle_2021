package lection3.task1;

import java.util.Random;

public class FixPriceShop {
    private static final int MAX_PRICE = 100;
    private static final int MIN_PRICE = 10;
    private static final int DISCOUNT_PERCENT = 50;

    static int price = 0;
    private String[] items;
    private int itemsCount;
    private int happyHour;

    public FixPriceShop(){
        Random random = new Random();
        if(price <= 0) {
            price = random.nextInt(MAX_PRICE) + MIN_PRICE;
            System.out.printf("Единая цена во всех магазинах: %s\n\n", price);
        }
        happyHour = random.nextInt(24);
        itemsCount = random.nextInt(11) + 10;
        items = createItemsArray();
    }

    private String[] createItemsArray(){
        String [] allPossibleItems = {"Тарелки","Стаканы","Ложки","Вилки","Ножи","Уголь","Зонт",
                "Мангал","Шампуры","Розжиг","Салфетки","Скатерть","Стул","Стол","Кепка","Носки","Сланцы",
                "Зажигалка","Спички","Фонарик","Топор","Лопата","Пила","Котелок","Батарейки",
                "Мыло","Антисептик","Фумигатор","Рюкзак","Сумка"};
        String [] createdItemsArray = new String[itemsCount];
        Random random = new Random();
        for (int i = 0; i < createdItemsArray.length; i++) {
            createdItemsArray[i] = allPossibleItems[random.nextInt(30)];
        }
        return createdItemsArray;
    }

    public int checkItemPrice(String item, int hour){
        for(String itemInShop: items){
            if(item.equals(itemInShop)){
                return (hour == happyHour)? (price-(price*DISCOUNT_PERCENT/100)) : price;
            }
        }
        return -1;
    }

    public String[] getItems(){
        String[] availableItems = new String[itemsCount];
        int i = 0;
        for(String item: items){
            if(item != null){
                availableItems[i] = item ;
                i++;
            }
        }
        return availableItems;
    }

    void buyItem(String item, int hour){
        for(int i=0; i<items.length; i++){
            if(item.equals(items[i])){
                System.out.printf("Товар %s продан по цене %s\n", item,
                        (hour == happyHour)? (price-(price*DISCOUNT_PERCENT/100)) : price);
                items[i] = null;
                return;
            }
        }
        System.out.printf("Товар %s не обнаружен\n", item);
    }

    public int getHappyHour() {
        return happyHour;
    }
}
