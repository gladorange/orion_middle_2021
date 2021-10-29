package com.example.shopItem;

public class TV extends ElectronicItem {
    private int volume;

    public TV(String name, Double price, int powerConsumption, int volume) {
        super(name, price, powerConsumption);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
