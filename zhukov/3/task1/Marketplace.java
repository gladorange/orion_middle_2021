package task1;
import task1.FixPriceShop;
import task1.ProductGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Marketplace {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            FixPriceShop shop = new FixPriceShop( ProductGenerator.getRandUniqueProducts(5) );

            shop.showProducts();

            String randProduct = shop.getRandProduct();
            System.out.printf("Случайный продукт для покупки - \"%s\" \n", randProduct);

            int betterTime = Marketplace.findBetterTime(shop, randProduct);
            System.out.printf("Лучшее время для покупок %s \n", betterTime);

            shop.buyItem(randProduct, betterTime);
            shop.showProducts();
            shop.buyItem(randProduct, betterTime);
            System.out.print("------------------ \n");
        }



    }

    public static int findBetterTime(Shop shop, String product){
        int hourFrom = 0;
        int hourTo = 24;
        int bestHour = 0;
        float price = 0;

        for (int hour = hourFrom ; hour<hourTo; hour++){
            if(hour == bestHour ){
                price = shop.checkItemPrice(product,hour);
            }else if(price > shop.checkItemPrice(product,hour) ){
                price = shop.checkItemPrice(product,hour);
                bestHour = hour;
            }
        }
        return bestHour;
    }
}
