package lection9.task1;

import java.awt.*;

@Task1.XmlTypeName(xmlTypeName = "Автомобиль")
class Car {

    @Task1.XmlName(xmlName = "Марка")
    String name;

    @Task1.XmlName(xmlName = "МаксСкорость")
    Double maxSpeed;

    @Task1.XmlIgnore
    Color color;

    public Car(String name, Double maxSpeed, Color color) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public Car() {
        this("", 100.0, Color.RED);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                "}\n";
    }
}
