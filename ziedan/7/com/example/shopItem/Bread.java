package com.example.shopItem;

public class Bread extends FoodItem {
    /**
     * Weight in grams
     */
    private int weight;

    public Bread(String name, Double price, int calories, int expiresIn, int weight) {
        super(name, price, calories, expiresIn);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
