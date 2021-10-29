package lection7.task1.items;

/**
 * дополнительное поля калорийность (calorieContent)
 * и срок годности в днях (shelfLife).
 */
public class FoodItem extends ShopItem{
    private final Double calorieContent;
    private final Integer shelfLife;

    public FoodItem(String name, Double price, Double calorieContent, Integer shelfLife) {
        super(name, price);
        this.calorieContent = calorieContent;
        this.shelfLife = shelfLife;
    }

    public Double getCalorieContent() {
        return calorieContent;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }
}
