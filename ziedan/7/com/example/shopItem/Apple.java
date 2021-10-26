package com.example.shopItem;

public class Apple extends FoodItem {
    private String color;

    public Apple(String name, Double price, int calories, int expiresIn, String color) {
        super(name, price, calories, expiresIn);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
