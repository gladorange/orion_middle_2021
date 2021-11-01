package lection7.task1.items;

/**
 * Дополнительное свойство - вес  в граммах (weight)
 */
public class Bread extends FoodItem{
    private final Integer weight;

    public Bread(String name, Double price, Double calorieContent, Integer shelfLife, Integer weight) {
        super(name, price, calorieContent, shelfLife);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return "Хлеб";
    }

    @Override
    public String toString() {
        return "Хлеб(" + super.toString() +
                "вес:" + weight + "г.)";
    }

}
