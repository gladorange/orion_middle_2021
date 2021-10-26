package com.example.shopItem;

public class ElectronicItem extends ShopItem {

    private int powerConsumption;

    public ElectronicItem(String name, Double price, int powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
