package items.foods;

import items.ShopItem;

import java.util.Objects;

public abstract class FoodItem extends ShopItem {
    private final int calorieContent;

    public FoodItem(String name, int price, int calorieContent) {
        super(name, price);
        this.calorieContent = calorieContent;
    }

    public int getCalorieContent() {
        return calorieContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return calorieContent == foodItem.calorieContent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calorieContent);
    }
}
