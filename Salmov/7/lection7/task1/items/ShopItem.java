package lection7.task1.items;

public abstract class ShopItem {
    private final String name;
    private final Double price;

    public ShopItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s, цена:%.2fр., ", name, price);
    }
}
