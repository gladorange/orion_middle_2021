package task3;

import java.util.Arrays;
import java.util.Objects;

public class FixPriceShop {
    private String[] items = new String[]{};
    private static int price = 49;
    private int hour;
    private int happyHour;

    public FixPriceShop(int happyHour) {
        this.happyHour = happyHour;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getHappyHour() {
        return happyHour;
    }

    public String[] getItems() {
        return items;
    }

    public int checkItemPrice(String item, int hour) {
        boolean isExists = false;
        if (hour == happyHour) {
            price = price / 2;
        }

        for (String itemTemp : items) {
            if (item.equals(itemTemp)) {
                isExists = true;
                break;
            }
        }

        if (isExists) {
            return price;
        } else {
            return -1;
        }
    }

    public void buyItem(String item, int hour) {
        int priceForGoods = checkItemPrice(item, hour);
        if (priceForGoods == -1) {
            System.out.printf("%nItem %s doesn't exist %n", item);
        } else {
            System.out.printf("%nItem %s sold for a price: %d %n", item, priceForGoods);
            String[] itemsTemp = deleteSoldItem(item);
            this.setItems(itemsTemp);
        }

    }

    private String[] deleteSoldItem(String item) {
        String[] itemsTemp = getItems();
        String[] afterSoldItemsWithNulls = new String[itemsTemp.length];

        for (int i = 0; i < itemsTemp.length; i++) {
            if (!item.equals(itemsTemp[i])) {
                afterSoldItemsWithNulls[i] = itemsTemp[i];
            }
        }

        String[] afterSoldItems = new String[afterSoldItemsWithNulls.length - 1];

        int count = 0;
        for (String afterSoldItemsWithNull : afterSoldItemsWithNulls) {
            if (afterSoldItemsWithNull != null) {
                afterSoldItems[count] = afterSoldItemsWithNull;
                count++;
            }
        }
        return afterSoldItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceShop that = (FixPriceShop) o;
        return price == that.price && hour == that.hour && happyHour == that.happyHour && Arrays.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(price, hour, happyHour);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
