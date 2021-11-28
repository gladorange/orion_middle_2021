package com.orion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProxyExample {



    interface ShopService {
        String getShopName();
        List<String> getItems();
    }

    static class ShopImpl implements ShopService {
        String name;
        List<String> items;

        public ShopImpl(String name, List<String> items) {
            this.name = name;
            this.items = items;
        }

        public String getShopName() {
            return name;
        }

        public List<String> getItems() {
            return items;
        }
    }




    public static void main(String[] args) {
        ShopService shop = getShopService("Пятерочка", Arrays.asList("Молоко", "Хлеб", "Сигареты"));
        ShopService shop1 = getShopService("Магнит", Arrays.asList("Мороженое", "Сигареты"));
        System.out.println(shop.getItems());
        System.out.println(shop.getShopName());
        System.out.println(shop1.getItems());
        System.out.println(shop1.getShopName());

    }

    private static ShopService getShopService(String name, List<String> items) {

        ShopImpl shop = new ShopImpl(name, items);

        final ShopService object = (ShopService)Proxy.newProxyInstance(ProxyExample.class.getClassLoader(), new Class[]{ShopService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if (method.getName().equals("getItems")) {
                    return shop.getItems()
                            .stream()
                            .filter(i -> !i.equals("Сигареты"))
                            .collect(Collectors.toList());
                }

                if (method.getName().equals("getShopName")) {
                    return shop.getShopName().toUpperCase();
                }

                return method.invoke(shop);

            }
        });
        return object;
    }
}
