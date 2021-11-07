package example;

import selialization.annotations.XmlName;
import selialization.annotations.XmlTypeName;

@XmlTypeName("Животное")
public class Animal {
    @XmlName("Имя")
    String name;

    @XmlName("Вид")
    String type;

    @XmlName("Домашний")
    boolean isPet;

    public Animal(String name, String type, boolean isPet) {
        this();
        this.name = name;
        this.type = type;
        this.isPet = isPet;
    }

    private Animal() {}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isPet=" + isPet +
                '}';
    }
}
