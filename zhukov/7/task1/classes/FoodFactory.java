package task1.classes;

import task1.enums.Colors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class FoodFactory {

    static List<ShopItem > products = new ArrayList<ShopItem>();

    static {
        products.add(new Apple("Зеленые яблоки",39.90,42, 30, Colors.GREEN ) );
        products.add(new Apple("Красные яблоки",29.90,50, 35, Colors.RED ) );
        products.add(new Apple("Желтые яблоки",13.90,50, 35, Colors.YELLOW ) );
        products.add(new Apple("Вымышленные яблоки",129.90,50, 35, Colors.WHITE ) );
        products.add(new Apple("Черные яблоки",129.90,50, 35, Colors.BLACK ) );

        products.add(new Bread("Бородинский хлеб",29.90,250, 3,190 ) );
        products.add(new Bread("Кунцевские булочки",49.50,530, 4,220 ) );
        products.add(new Bread("Белый батон",24.50,335, 8,300 ) );
        products.add(new Bread("Черный батон",24.50,335, 8,300 ) );
    }

    //public static <T extends Collection<? super ShopItem.FoodItem>> void fillShopWithFood(T shop){
    public static void fillShopWithFood(Collection<? super ShopItem.FoodItem> shop){
        Integer rand ;
        ShopItem product ;

        for (int i = 0 ; i < 6; i++){
            rand = ThreadLocalRandom.current().nextInt(0,products.size());
            product = products.get(rand);
            shop.add( (ShopItem.FoodItem)product );
        }
        String s =shop.stream()
                .map(p -> (ShopItem) p )
                .map( n -> n.getTitle())
                .collect(Collectors.toList()).toString();

        System.out.printf("Тип товаров: %s \n",s);

    }
}
