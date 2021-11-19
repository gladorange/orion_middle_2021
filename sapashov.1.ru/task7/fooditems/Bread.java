package task7.fooditems;

public class Bread extends FoodItem {
    private int weightInGram;

    public Bread(int weightInGram) {
        this.weightInGram = weightInGram;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "weightInGram=" + weightInGram +
                '}';
    }
}
