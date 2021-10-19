package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FixPriceShop implements Shop {

    private final static int PRICE = 49;
    private final static int DISCOUNT = 50;
    private final static int HAPPY_HOUR_FROM = 1;
    private final static int HAPPY_HOUR_TO = 23;

    private String[] items ;
    private int happyHour ;


    public FixPriceShop(String[] products) {
        this.items = products;
        this.happyHour = this.setHappyHour(HAPPY_HOUR_FROM, HAPPY_HOUR_TO);
        System.out.printf("Мы открылись! Счастливый час для покупок : %s \n", happyHour);
    }

    private int setHappyHour(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to );
    }

    public void showProducts(){
        System.out.printf("В данном магазине присутствуют товары : %s \n",this.getProductList()) ;
    }

    // В задании было указано создать функцию типа int, но цена может быть не обязательно целым числом
    public float checkItemPrice(String item, int hour){
        ArrayList<String> products = this.getProductList();

        if( products.contains(item) ){
            return this.getPrice(hour);
        }else{
            return -1;
        }
    }

    public String getRandProduct(){
        int randIndex = ThreadLocalRandom.current().nextInt(0, this.items.length - 1) ;
        return this.items[randIndex];
    }

    public void buyItem(String item, int hour){
        float productPrice = this.checkItemPrice(item, hour);

        System.out.printf("Время покупки %s \n", hour  );

        if( Math.signum ( productPrice ) == 1   ){
            ArrayList<String> products = this.getProductList();
            products.remove(item);
            this.items =  products.toArray(new String[products.size()]) ;

            System.out.printf("Товар \"%s\" продан по цене %s \n", item , productPrice );
        }else{
            System.out.printf("Товар \"%s\" не обнаружен \n", item  );
        }
    }

    private ArrayList getProductList(){
        return new ArrayList<>(Arrays.asList(this.items));
    }

    private float getPrice(int curHour){
        float price = (curHour == this.happyHour )
                ? ((float)this.PRICE/100) * (float)this.DISCOUNT
                : (float) this.PRICE;
        return price;
    }

}
