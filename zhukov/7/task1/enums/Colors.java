package task1.enums;

public enum Colors {
    RED("Красный"),
    WHITE("Белый"),
    YELLOW("Желтый"),
    GREEN("Зеленый"),
    BLACK("Черный");

    String title;
    Colors(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
