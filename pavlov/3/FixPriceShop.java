import java.util.Arrays;
import java.util.Objects;

public class FixPriceShop {
    public final static int PERCENT_DISCOUNT = 50;
    public final static int MIN_HAPPY_HOUR = 0;
    public final static int MAX_HAPPY_HOUR = 23;
    public final static int DEFAULT_PRICE = 49;

    private static int price = DEFAULT_PRICE;

    private String[] items;
    private int happyHour;

    FixPriceShop(String[] items, int happyHour){
        this.items = items;
        this.happyHour = validateHour(happyHour);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        FixPriceShop.price = price;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getHappyHour() {
        return happyHour;
    }

    public void setHappyHour(int happyHour) {
        this.happyHour = validateHour(happyHour);
    }

    public void buyItem(String item, int hour){
        int calculatedPrice = checkItemPrice(item, hour);
        if(calculatedPrice == -1){
            System.out.printf("Товар %s не обнаружен\n", item);
            return;
        }
        System.out.printf("товар %s продан по цене %d\n", item, calculatedPrice);
        items = Arrays.stream(items)
                .filter(i -> !item.equals(i))
                .toArray(String[]::new);
    }

    public int checkItemPrice(String item, int hour){
        hour = validateHour(hour);
        for(String shopItem: items){
            if(shopItem.equals(item)){
                return calculatePrice(hour);
            }
        }
        return -1;
    }

    private int validateHour(int happyHour) throws IllegalArgumentException{
        if(happyHour >= MIN_HAPPY_HOUR && happyHour <= MAX_HAPPY_HOUR){
            return happyHour;
        }
        throw new IllegalArgumentException("Счастливый час должен быть между " + MIN_HAPPY_HOUR + " и " + MAX_HAPPY_HOUR);
    }

    private int calculatePrice(int currentHour){
        if(currentHour == happyHour){
            return (int) (price * (PERCENT_DISCOUNT/100f));
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceShop that = (FixPriceShop) o;
        return happyHour == that.happyHour &&
                Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(happyHour);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    @Override
    public String toString() {
        return "FixPriceShop{" +
                "items=" + Arrays.toString(items) +
                ", happyHour=" + happyHour +
                '}';
    }
}
