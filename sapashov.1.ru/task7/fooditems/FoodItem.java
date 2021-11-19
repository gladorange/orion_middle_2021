package task7.fooditems;

import task7.ShopItem;

public class FoodItem extends ShopItem {
    private int calorieContent;

    @Override
    public String toString() {
        return "FoodItem{" +
                "calorieContent=" + calorieContent +
                '}';
    }
}
