package task1.classes;

import task1.enums.Colors;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;



public class AppleGarden {

    static List<Apple> products = new ArrayList<Apple>();

    static {
        products.add(new Apple("Зеленые яблоки",39.90,42, 30, Colors.GREEN ) );
        products.add(new Apple("Красные яблоки",29.90,50, 35, Colors.RED ) );
        products.add(new Apple("Желтые яблоки",13.90,50, 35, Colors.YELLOW ) );
        products.add(new Apple("Вымышленные яблоки",129.90,50, 35, Colors.WHITE ) );
        products.add(new Apple("Черные яблоки",129.90,50, 35, Colors.BLACK ) );
        }


    public static   void fillShopWithApples(Collection<? super ShopItem.FoodItem > shop){
        Integer rand ;
        Apple product ;

        Set<String> addedColors =  new  HashSet<String>();

        for (int i = 0 ; i < 6; i++){
            rand = ThreadLocalRandom.current().nextInt(0,products.size());
            product = products.get(rand);
            shop.add( product );
            addedColors.add(  product.getColor().getTitle() );
        }

        System.out.printf("В магазин добавлены яблоки: %s \n",addedColors);

    }
}
