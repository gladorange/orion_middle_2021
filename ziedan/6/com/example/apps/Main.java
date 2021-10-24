package com.example.apps;

import com.example.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final List<Triple<String, Integer, Double>> apps = new ArrayList<>();

    static {
        apps.add(new Triple<String, Integer, Double>("Facebook", 121935069, 2.6));
        apps.add(new Triple<String, Integer, Double>("Messenger", 80436215, 4.0));
        apps.add(new Triple<String, Integer, Double>("Chrome", 34545717, 4.1));
        apps.add(new Triple<String, Integer, Double>("Youtube", 124752602, 4.3));
        apps.add(new Triple<String, Integer, Double>("Whatsapp", 147874075, 4.1));
        apps.add(new Triple<String, Integer, Double>("2gis", 987621, 4.3));
        apps.add(new Triple<String, Integer, Double>("hh", 756759, 4.8));
        apps.add(new Triple<String, Integer, Double>("Avito", 2454351, 4.5));
        apps.add(new Triple<String, Integer, Double>("Yandex Go", 3034274, 4.9));
    }

    public static void main(String[] args) {

        List<Triple<String, Integer, Double>> sortedByTotalRatings = sortByTotalRatings(apps);
        List<Triple<String, Integer, Double>> sortedByWorstRating = sortByWorstRating(apps);
        List<Triple<String, Integer, Double>> sortedByBestRating = sortByBestRating(apps);

        System.out.println(sortedByTotalRatings);
        System.out.println(sortedByWorstRating);
        System.out.println(sortedByBestRating);
    }

    private static List<Triple<String, Integer, Double>> sortByWorstRating(List<Triple<String, Integer, Double>> ratings) {
        List<Triple<String, Integer, Double>> sorted = new ArrayList<>(ratings);
        sorted.sort(Comparator.comparingDouble(Triple::getThird));
        return sorted;
    }

    private static List<Triple<String, Integer, Double>> sortByBestRating(List<Triple<String, Integer, Double>> ratings) {
        List<Triple<String, Integer, Double>> sorted = new ArrayList<>(ratings);
        sorted.sort(Comparator.comparing(Triple::getThird, Comparator.reverseOrder()));
        return sorted;
    }

    private static List<Triple<String, Integer, Double>> sortByTotalRatings(List<Triple<String, Integer, Double>> ratings) {
        List<Triple<String, Integer, Double>> sorted = new ArrayList<>(ratings);
        sorted.sort(Comparator.comparing(Triple::getSecond, Comparator.reverseOrder()));
        return sorted;
    }

}
