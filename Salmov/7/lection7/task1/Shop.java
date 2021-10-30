package lection7.task1;

import java.util.ArrayList;

public class Shop<T> extends ArrayList<T> {
    private final String name;
    public Shop(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
