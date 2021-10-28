package items.foods;

import java.util.Objects;

public class Bread extends FoodItem {
    private final int weight;

    public Bread(String name, int price, int calorieContent, int weight) {
        super(name, price, calorieContent);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bread bread = (Bread) o;
        return weight == bread.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}
