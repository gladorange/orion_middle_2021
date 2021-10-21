package ru.task3;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static ru.task3.FixPriceShop.FIX_PRICE;

public class Main {
    public static void main(String[] args) {

        final int FIX_PRICE_SHOPS_NUM = 3;   //  fixPriceShops total number
        final String [][] FIX_PRICE_SHOPS_GOODS = { {"Processor", "MB", "Memory", "Cooler Fan", "Monitor", "Mouse", "Microphone", "Speakers", "SoundCard", "Video", "Keyboard", "Power supply", "CD-ROM", "USB hub", "WiFi Router" },
                {"война и мир", "отцы и дети", "преступление и наказание", "Далекое - близкое", "Хоббит или Туда и обратно", "South and North",
                        "black and white", "ricchi e poveri", "Бонни и Клайд", "песнь льда и пламени", "The Sparrows And The Nightingales", "High Tech & Low Life" },
                {"Ski", "Skates", "Ball", "Rackets", "Board", "Weight", "Swim suit", "Helmet", "Puck", "Hockey stick", "Glasses", "Boots", "Shirts" } };
         /*
        Создайте 3 магазина
        Каждый магазин заполните случайными товарами. Лучше будет, если каждый магазин получит разный набор товаров.
        */
        FixPriceShop[] myShops = new FixPriceShop[FIX_PRICE_SHOPS_NUM];
        for (int i = 0; i < FIX_PRICE_SHOPS_NUM; i++) {
            myShops[i] = new FixPriceShop(FIX_PRICE_SHOPS_GOODS[i]);

            //  check for total amount of items in shop:
            int itemsNum = myShops[i].getItems().length;
            if (0 == itemsNum) {
                System.out.println("Этот магазин пуст (в нём нет товаров) - ничего не покупаем!");
                continue;
            }
            //  Из каждого магазина выберите случайный товар (для этого придется получить сначала список всех товаров)
            String randItem = myShops[i].getItems()[ThreadLocalRandom.current().nextInt(0, itemsNum)];
            /*
            и найдите оптимальное время для его покупки (т.е. время, когда действует счастливый час)
            используя функцию checkItemPrice
            */
            int optimalHour = getOptimalHour (myShops[i], randItem);
            System.out.printf("Случайный товар: <%s>, оптим.время покупки: %d час.дня\n", randItem, optimalHour);
            /*
            Купите этот товар.
            */
            myShops[i].buyItem(randItem, ThreadLocalRandom.current().nextInt(0, (int) Duration.ofDays(1).toHours()));
            /*
            попробуйте купить этот же самый товар еще раз, посмотрите консоль и убедитесь,
                    что товар не обнаружен (при условии, что одинаковых товаров не было)
            */
            myShops[i].buyItem(randItem, optimalHour);
        }
    }

    /**
    и найдите оптимальное время для его покупки (т.е. время, когда действует счастливый час)
    используя функцию checkItemPrice
     * @return optimal hour to buy this item, -1 if error
     */
    static int getOptimalHour(FixPriceShop shop, String item) {
        for (int hour = 0; hour < (int) Duration.ofDays(1).toHours(); hour++) {
            if (shop.checkItemPrice(item, hour) < FIX_PRICE) {
                return hour;
            }
        }
        return -1;  //  optimal hour not found :(
    }
}
