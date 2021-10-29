package com.example.shopItem;

public class Refrigerator extends ElectronicItem {
    private int freezingCapacity;

    public Refrigerator(String name, Double price, int powerConsumption, int freezingCapacity) {
        super(name, price, powerConsumption);
        this.freezingCapacity = freezingCapacity;
    }

    public int getFreezingCapacity() {
        return freezingCapacity;
    }

    public void setFreezingCapacity(int freezingCapacity) {
        this.freezingCapacity = freezingCapacity;
    }
}
