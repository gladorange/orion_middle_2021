package com.example.shopItem;

public class FoodItem extends ShopItem {
    private int calories;
    /**
     * Expiry period in days
     */
    private int expiresIn;

    public FoodItem(String name, Double price, int calories, int expiresIn) {
        super(name, price);
        this.calories = calories;
        this.expiresIn = expiresIn;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
