import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        FixPriceShop[] shops = generateShops(generateStrings(50, "Товар"), 3);

        for(int i=0; i<shops.length; i++){
            System.out.printf("Магазин %d\n", i);
            System.out.println(shops[i].toString());

            FixPriceShop shop = shops[i];
            String randItem = randomItems(new Random(), shop.getItems(), 1)[0];
            int happyHour = findHappyHour(shop, randItem);

            System.out.printf("Выбран случайный товар %s. Оптимальное время для покупки: %d \n", randItem, happyHour);
            shop.buyItem(randItem, happyHour);
            shop.buyItem(randItem, happyHour);
        }
    }

    private static String[] generateStrings(int size, String prefix){
        String[] result = new String[size];
        for(int i=0; i<result.length; i++){
            result[i] = "Товар" + i;
        }
        return result;
    }

    private static FixPriceShop[] generateShops(String[] allItems, int shopsAmount){
        FixPriceShop[] result = new FixPriceShop[shopsAmount];

        Random random = new Random();

        for(int i=0; i<shopsAmount; i++){
            int happyHour = random.nextInt(FixPriceShop.MAX_HAPPY_HOUR - FixPriceShop.MIN_HAPPY_HOUR) + FixPriceShop.MIN_HAPPY_HOUR;
            String[] items = randomItems(random, allItems, random.nextInt(allItems.length) + 1);
            result[i] = new FixPriceShop(items, happyHour);
        }

        return result;
    }

    private static String[] randomItems(Random random, String[] allItems, int itemsSize){

        Set<String> set = new HashSet<>(itemsSize);

        for(int i=0; i<itemsSize; i++){
            int randomIndex = random.nextInt(allItems.length);
            set.add(allItems[randomIndex]);
        }

        String[] result = new String[set.size()];
        return set.toArray(result);
    }

    private static int findHappyHour(FixPriceShop shop, String item){
        int price = shop.getPrice();
        for (int hour=FixPriceShop.MIN_HAPPY_HOUR; hour<=FixPriceShop.MAX_HAPPY_HOUR; hour++){
            int checkedPrice = shop.checkItemPrice(item, hour);
            if(checkedPrice != -1 && checkedPrice < price){
                return hour;
            }
        }
        return -1;
    }
}
