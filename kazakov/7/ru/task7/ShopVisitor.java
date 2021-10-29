package ru.task7;

import java.util.*;

/*
Создайте интерфейс ShopVisitor с единственным методом
        void visitShop, на вход он принимает "магазин",т.е. какую-то коллекцию, содержащую ShopItem или его наследником.
*/
public interface ShopVisitor {
    void visitShop(Collection<? extends ShopItem> shop);
}

/*
    Создайте три конкретных посетителя:
        - ImJustLookingVisitor - который просто смотрит товары и выводит их на консоль в формате Название - цена
        - ElectronicAddictedVisitor - который выводит на экран всю электронику.
        После вывода такой посетитель покупает электронный товар с самой большой потребляемой мощностью.
        "Покупает" - значит на экран выводится надпись "имя_товара куплен по цена_товара" и товар удаляется из коллекции.
        - RichVisitor - который покупает каждый второй товар в магазине.
 */
class ImJustLookingVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ru.task7.ShopItem> shop) {
        //  - который просто смотрит товары и выводит их на консоль в формате Название - цена
        shop.forEach(x -> System.out.printf("просто смотрю: %s, вижу цену:  %.2f\n", x.getName(), x.getPrice()));
    }
}

class ElectronicsAddictVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ru.task7.ShopItem> shop) {
        //  - ElectronicAddictedVisitor - который выводит на экран всю электронику.
        shop.forEach(x -> {
            if (x instanceof ElectronicItem)
                System.out.printf("%s -  %.2f\n", x.getName(), x.getPrice());
        });
        /*
             После вывода такой посетитель покупает электронный товар с самой большой потребляемой мощностью.
            "Покупает" - значит на экран выводится надпись "имя_товара куплен по цена_товара" и товар удаляется из коллекции.
        */
        shop.stream()
                .filter(x -> x instanceof ElectronicItem)
                .max(Comparator.comparing(x -> ((ru.task7.ElectronicItem) x).getPowerConsumption()))
                .ifPresent(x -> {
                    System.out.printf("%s хватаю по цене: %.2f\n", x.getName(), x.getPrice());
                    //   и товар удаляется из коллекции.
                    shop.remove(x);
                });
    }
}

class RichVisitor implements ShopVisitor {
    @Override
    public void visitShop(Collection<? extends ShopItem> shop) {
        //  -  который покупает каждый второй товар в магазине.
        //  "Покупает" - значит на экран выводится надпись "имя_товара куплен по цена_товара" и товар удаляется из коллекции.
        Iterator<? extends ShopItem> iterator = shop.iterator();

        System.out.printf("Перед походом RICHVISITOR в магазине БЫЛО товаров: %d\n", shop.size());
        int i = 0;
        while (iterator.hasNext()) {
            ShopItem item = iterator.next();
            if (i % 2 == 0) {
                System.out.printf("%s куплен по цене: %.2f\n", item.getName(), item.getPrice());
                iterator.remove();
            }
            i++;
        }
        System.out.printf("После похода RICHVISITOR в магазине СТАЛО товаров: %d\n", shop.size());
    }
}

