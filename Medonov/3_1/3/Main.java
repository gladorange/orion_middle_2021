import java.time.LocalTime;

public class Main {
    // Любой созданный магазин заполняется рандомными товарами из перечня товаров. При покупке товара - товар удаляется из массива.
    public static void main(String[] args) {
        FixPriceShop aFixPriceShop = new FixPriceShop();
        for (String aItem : aFixPriceShop.getItems()) {
            System.out.println(aItem);
        }
        aFixPriceShop.buyItem("Аварийный жилет", LocalTime.now().getHour());

        FixPriceShop aFixPriceShop2 = new FixPriceShop();
        for (String aItem : aFixPriceShop2.getItems()) {
            System.out.println(aItem);
        }
        aFixPriceShop.buyItem("Брелок для ключей", LocalTime.now().getHour());

        FixPriceShop aFixPriceShop3 = new FixPriceShop();
        for (String aItem : aFixPriceShop3.getItems()) {
            System.out.println(aItem);
        }
        aFixPriceShop.buyItem("Клипса крепления коврика салона", LocalTime.now().getHour());
    }
}