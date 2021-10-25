package com.example.fuel;

import com.example.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.example.fuel.FuelType.*;

public class Main {
    private static final List<Triple<String, FuelType, Double>> fuelPrices = new ArrayList<>();

    static {
        fuelPrices.add(new Triple<>("IRBIS - г. Казань, ул. Космонавтов, 65к", Diesel, 49.99));
        fuelPrices.add(new Triple<>("Наиком - г. Набережные Челны, Вахитовское кольцо, 4", Gasoline95, 49.31));
        fuelPrices.add(new Triple<>("IRBIS - М7, 843-й км (506-й км), справа", Diesel, 49.99));
        fuelPrices.add(new Triple<>("Татнефтепродукт - г. Чистополь, ул. Карла Маркса, 85", Diesel, 48.50));
        fuelPrices.add(new Triple<>("Татнефтепродукт - г. Казань, ул. Николая Ершова", Gasoline98, 57.70));
        fuelPrices.add(new Triple<>("Татнефтепродукт - Р239, 10-й км, справа", Gasoline98, 57.70));
        fuelPrices.add(new Triple<>("Татнефтепродукт - г. Чистополь, Объездная дорога", Gasoline95, 48.45));
        fuelPrices.add(new Triple<>("Татнефтепродукт - г. Чистополь, Объездная дорога", Gasoline92, 44.80));
        fuelPrices.add(new Triple<>("Татнефтепродукт - М7, 899-й км (451-й км), справа", Diesel, 48.60));
        fuelPrices.add(new Triple<>("Газпромнефть - г. Казань, ул. Минская, 1а", Diesel, 49.05));
        fuelPrices.add(new Triple<>("Газпромнефть - г. Казань, ул. Минская, 1а", Gasoline95, 49.35));
        fuelPrices.add(new Triple<>("Газпромнефть - г. Казань, ул. Минская, 1а", Gasoline92, 45.00));
        fuelPrices.add(new Triple<>("Опти - с. Старое Байсарово, М7, 1163-й км (186-й км), слева", Diesel, 48.69));
        fuelPrices.add(new Triple<>("Опти - с. Старое Байсарово, М7, 1163-й км (186-й км), слева", Gasoline95, 48.19));
        fuelPrices.add(new Triple<>("Опти - с. Старое Байсарово, М7, 1163-й км (186-й км), слева", Gasoline92, 45.69));
    }

    public static void main(String[] args) {
        System.out.println(findBestPrice(fuelPrices, Gasoline92).toString());
    }

    public static Triple<String, FuelType, Double> findBestPrice(List<Triple<String, FuelType, Double>> prices, FuelType fuelType) {
        Optional<Triple<String, FuelType, Double>> minPrice = prices.stream()
                .filter(price -> price.getSecond().equals(fuelType))
                .min(Comparator.comparingDouble(Triple::getThird));
        return minPrice.orElse(null);
    }

}
