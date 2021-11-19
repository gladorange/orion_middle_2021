package task1.classes;

public class Bread extends ShopItem.FoodItem{

    private Integer weight ;
    Bread(String title, Double price, Integer caloric, Integer expirationDays,Integer weight){
        super(title, price, caloric,  expirationDays);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Хлеб " + getTitle()
                ;
    }
}
