package lection7.task1.items;

/**
 * дополнительное поля калорийность (calorieContent)
 * и срок годности в днях (shelfLife).
 */
public abstract class FoodItem extends ShopItem{
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

    @Override
    public String toString() {
        return super.toString() + String.format("калорийность:%.2fкКал, срок годности:%s дн., ",
                calorieContent, shelfLife);
    }

}
