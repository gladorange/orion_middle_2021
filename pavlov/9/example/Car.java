package example;

import selialization.annotations.XmlName;
import selialization.annotations.XmlTypeName;

@XmlTypeName("Автомобиль")
public class Car {
    @XmlName("Производитель")
    String producer;

    @XmlName("УровеньТоплива")
    int currentFuelLevel;

    public Car(String producer, int currentFuelLevel) {
        this();
        this.producer = producer;
        this.currentFuelLevel = currentFuelLevel;
    }

    private Car(){}

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", currentFuelLevel=" + currentFuelLevel +
                '}';
    }
}
