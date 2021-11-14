package task7.fooditems;


public class Apple extends FoodItem {
    private String color;

    public Apple(String randomColor) {
        color = randomColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}
