package task1.classes;

import task1.enums.Colors;

public class Apple extends ShopItem.FoodItem {

    Colors color;

    Apple(String title, Double price,Integer caloric, Integer expirationDays, Colors color) {
        super(title, price,caloric, expirationDays);
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "Яблоки :"+getTitle() ;
    }
}
