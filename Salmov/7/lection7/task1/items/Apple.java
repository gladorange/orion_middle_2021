package lection7.task1.items;

/**
 * Дополнительное свойство - цвет (color).
 */
public class Apple extends FoodItem{
    private final FruitColor color;

    public Apple(String name, Double price, Double calorieContent, Integer shelfLife, FruitColor color) {
        super(name, price, calorieContent, shelfLife);
        this.color = color;
    }

    public FruitColor getColor() {
        return color;
    }

    @Override
    public String getType() {
        return "Яблоки";
    }

    @Override
    public String toString() {
        return "Яблоки(" + super.toString() +
                "цвет:" + color.getName() + ")";
    }

}

