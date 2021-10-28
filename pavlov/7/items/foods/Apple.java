package items.foods;

import java.util.Objects;

public class Apple extends FoodItem {
    private final String color;

    public Apple(String name, int price, int calorieContent, String color) {
        super(name, price, calorieContent);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
