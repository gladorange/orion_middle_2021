package com.example.fuel;

public enum FuelType {
    Diesel("ДТ"),
    Gasoline92("АИ-92"),
    Gasoline95("АИ-95"),
    Gasoline98("АИ-98");


    public final String label;

    FuelType(String label) {
        this.label = label;
    }
}
