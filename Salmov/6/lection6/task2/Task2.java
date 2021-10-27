package lection6.task2;
//Домашнее задание к лекции 6
//Пара-Тройка кортежей
//Задание Б
//Списки, списки...
//Салмов Евгений


import lection4.task1.spells.Spell;
import lection6.tuples.Triple;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    static final Double MIN_DT_PRICE = 49.10;
    static final Double MAX_DT_PRICE = 49.99;
    static final Double MIN_AI92_PRICE = 44.95;
    static final Double MAX_AI92_PRICE = 46.95;
    static final Double MIN_AI95_PRICE = 49.25;
    static final Double MAX_AI95_PRICE = 51.25;
    static final Double MIN_AI98_PRICE = 54.97;
    static final Double MAX_AI98_PRICE = 56.97;
    static final Integer MIN_RATINGS_CNT = 100;
    static final Integer MAX_RATINGS_CNT = 500_000_000;
    static final Double MIN_RATING = 1.0;
    static final Double MAX_RATING = 5.0;

    enum GasolineType{
        DT("ДТ"), AI92("АИ-92"), AI95("АИ-95"), AI98("АИ-98");
        private final String name;
        GasolineType(String name){
            this.name = name;
        }
        public String getName(){ return name;}
    }

    public static void main(String[] args) {
        workWithGasStations();
        System.out.println();
        workWithApplications();
    }

    private static void workWithGasStations() {
        System.out.println("Поработаем со списком бензоколонок");
        String[] addresses = {"Пенза, ул. Рябова, 1Д", "Пенза, ул. Измайлова, 58", "Пенза, ул. Чаадаева, 165",
                "Пенза, ул. Окружная, 298","Пенза, ул. Аустрина, 71"};
        List<Triple<String,GasolineType,Double>> gasStations = new ArrayList<>();
        for (String address: addresses) {
            for (GasolineType type: GasolineType.values() ) {
                gasStations.add(new Triple<>(address, type, makeGasolinePrice(type)) );
            }
        }
        for (Triple<String,GasolineType,Double> gasStation: gasStations ) {
            System.out.printf("%s  -  %s  -  %.2f\n", gasStation.getFirst(),
                    gasStation.getSecond().getName(), gasStation.getThird());
        }
        System.out.println();
        for (GasolineType type: GasolineType.values() ) {
            System.out.println("Адрес бензоколонки с самой низкой ценой на " + type.getName());
            findBestPrice(gasStations, type);
        }
    }

    private static void findBestPrice(List<Triple<String,GasolineType,Double>> list,GasolineType type ){
        List<Triple<String,GasolineType,Double>> filteredList = list.stream().filter(
                gs -> gs.getSecond() == type).collect(Collectors.toList());
        final Triple<String,GasolineType,Double> min = Collections.min(filteredList,
                Comparator.comparing(Triple::getThird));
        System.out.printf("%s  (Цена: %.2f)\n", min.getFirst(), min.getThird());
    }

    private static Double makeGasolinePrice(GasolineType type){
        Random random = new Random();
        switch (type) {
            case DT:
                return (random.nextDouble()*(MAX_DT_PRICE-MIN_DT_PRICE) + MIN_DT_PRICE);
            case AI92:
                return (random.nextDouble()*(MAX_AI92_PRICE-MIN_AI92_PRICE) + MIN_AI92_PRICE);
            case AI95:
                return (random.nextDouble()*(MAX_AI95_PRICE-MIN_AI95_PRICE) + MIN_AI95_PRICE);
            case AI98:
                return (random.nextDouble()*(MAX_AI98_PRICE-MIN_AI98_PRICE) + MIN_AI98_PRICE);
        }
        return 0.0;
    }

    private static void workWithApplications() {
        System.out.println("Поработаем со списком приложений на телефоне");
        String[] appNames = {"Яндекс Go", "Яндекс.Карты", "Telegram",
                "Metronomerous","Booking.com","Blue Light Filter","Геотрекер"};
        List<Triple<String,Double,Double>> applications = new ArrayList<>();
        Random random = new Random();
        for (String app: appNames) {
            applications.add(new Triple<>(app,
                    (double)(random.nextInt(MAX_RATINGS_CNT-MIN_RATINGS_CNT) + MIN_RATINGS_CNT),
                    (random.nextDouble()*(MAX_RATING-MIN_RATING) + MIN_RATING)) );
        }
        printAppList(applications);
        System.out.println();
        System.out.println("Все приложения отсортированные по количеству оценок:");
        applications.sort(Comparator.comparing(Triple::getSecond));
        printAppList(applications);
        System.out.println();
        final Triple<String,Double,Double> max = Collections.max(applications,
                Comparator.comparing(Triple::getThird));
        System.out.println("Приложение с самым лучшим рейтингом: " + max.getFirst());
        final Triple<String,Double,Double> min = Collections.min(applications,
                Comparator.comparing(Triple::getThird));
        System.out.println("Приложение с самым худшим рейтингом: " + min.getFirst());
    }

    private static void printAppList(List<Triple<String,Double,Double>> applications) {
        for (Triple<String,Double,Double> app: applications )
            System.out.printf("Приложение: %s (Оценок: %.0f, рейтинг: %.2f)\n", app.getFirst(),
                app.getSecond(), app.getThird());
    }

}
