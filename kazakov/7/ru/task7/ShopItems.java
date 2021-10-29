package ru.task7;


//  Создайте абстрактный класс ShopItem с полями: название товара и цена продажи.
abstract class ShopItem {
private final String name;
private final Double price;

    protected ShopItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}

/*
 Создайте два наследника:
         - ElectronicItem: дополнительное поле потребляемая мощность.
*/
abstract class ElectronicItem extends ShopItem {
    private final Integer powerConsumption;
    protected ElectronicItem(String name, Double price, Integer powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }
}

/*
    Создайте два наследника:
            - FoodItem: дополнительное поля калорийность и срок годности в днях.
*/
abstract class FoodItem extends ShopItem {
    private final Integer caloricValue;
    private final Integer expiryPeriod;

    protected FoodItem (String name, Double price, Integer caloricValue, Integer expiryPeriod) {
        super(name, price);
        this.caloricValue = caloricValue;
        this.expiryPeriod = expiryPeriod;
    }

    public Integer getCaloricValue() {
        return caloricValue;
    }

    public Integer getExpiryPeriod() {
        return expiryPeriod;
    }
}

/*
    Создайте классы, описывающие конкретные товары, с дополнительными свойствами:
        - Apple.Дополнительное свойство - цвет
*/
class Apple extends FoodItem {
    private final String colour;
    protected Apple (String name, Double price, Integer caloric, Integer expiry, String colour) {
        super(name, price, caloric, expiry);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}

//  - Bread. Дополнительное свойство - вес  в граммах
class Bread extends FoodItem {
    private final Integer weight;
    protected Bread (String name, Double price, Integer caloric, Integer expiry,  Integer weight) {
        super(name, price, caloric, expiry);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }
}

//        - TV. Дополнительное свойство -  громкость
class TV extends ElectronicItem {
    private final Integer loudnessDb;
    protected TV (String name, Double price, Integer power, Integer loudnessInDecibel) {
        super(name, price, power);
        this.loudnessDb = loudnessInDecibel;
    }
}

//                - Refrigerator. Дополнительное свойство - объем морозильной камеры
class Refrigerator extends ElectronicItem {
    private final Integer freezerVolume;
    protected Refrigerator (String name, Double price, Integer power, Integer freezerVolume) {
        super(name, price, power);
        this.freezerVolume = freezerVolume;
    }
}
