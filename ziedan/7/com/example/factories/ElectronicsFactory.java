package com.example.factories;

import com.example.shopItem.ElectronicItem;
import com.example.shopItem.Refrigerator;
import com.example.shopItem.ShopItem;
import com.example.shopItem.TV;
import com.example.shops.ElectronicsShop;
import com.example.shops.HyperMarket;

import java.util.*;

public class ElectronicsFactory {
    private static List<TV> tvs = new ArrayList<>();
    private static List<Refrigerator> refrigerators = new ArrayList<>();

    static {
        tvs.add(new TV("Телевизор Polarline 32PL12TC 32\" (2019), черный", 10839.0, 120, 16));
        tvs.add(new TV("Телевизор LG 32LM6380PLC 32\" (2021), белый", 23990.0, 120, 10));
        tvs.add(new TV("Телевизор Samsung UE50TU7090U 50\" (2020), черный/серебристый", 43490.0, 120, 20));
        tvs.add(new TV("Телевизор Samsung UE24N4500AU 24\" (2018), черный", 15402.0, 120, 10));
        tvs.add(new TV("Телевизор Xiaomi Mi TV P1 43 43\" (2021), черный", 27990.0, 120, 20));
        tvs.add(new TV("Телевизор Prestigio 50 Odyssey 50\" (2020), черный", 17990.0, 120, 16));

        refrigerators.add(new Refrigerator("Холодильник ATLANT ХМ 4208-000", 16439.0, 250, 42));
        refrigerators.add(new Refrigerator("Холодильник ATLANT ХМ 6025-031", 26989.0, 250, 139));
        refrigerators.add(new Refrigerator("Холодильник LG GA-B419SQUL", 36990.0, 250, 79));
        refrigerators.add(new Refrigerator("Холодильник ATLANT ХМ 6023-031", 24789.0, 250, 154));
    }

    public static <T extends ArrayList<? super ElectronicItem>> void fillShopWithElectronicGoods(T shop) {
        Random random = new Random();
        int countProducts = random.nextInt(10);
        List<String> addedProducts = new ArrayList<>();

        for (int i = 0; i < countProducts; i++) {
            if (random.nextBoolean()) {
                TV tv = tvs.get(random.nextInt(tvs.size()));
                shop.add(tv);
                addedProducts.add(tv.getName());
            } else {
                Refrigerator refrigerator = refrigerators.get(random.nextInt(refrigerators.size()));
                shop.add(refrigerator);
                addedProducts.add(refrigerator.getName());
            }
        }

        if (!addedProducts.isEmpty()) {
            System.out.printf("В магазин добавлена электроника: %s %n", String.join(", \n", addedProducts));
        }
    }
}
