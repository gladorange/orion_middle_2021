import animals.Animal;
import corteges.Pair;
import corteges.Triple;
import gasoline.GasolineType;
import mobileApps.MobileApps;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        task1();
        taskA();
        taskB();
    }

    public static void task1(){
        String lastName = "";

        Pair<String, Integer> lastNameToAge = new Pair<> ("Пупкин", 18);
        lastName = lastNameToAge.getFirst();
        Integer age = lastNameToAge.getSecond();

        System.out.printf("lastName: %s, age: %s \n", lastName, age);

        Pair<String, List<String>> lastNameToPhoneNumbers = new Pair<>("Пупкин", Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        lastName = lastNameToPhoneNumbers.getFirst();
        List<String> phoneNumbers = lastNameToPhoneNumbers.getSecond();

        System.out.printf("lastName: %s, phoneNumbers: %s \n", lastName, phoneNumbers);
    }

    public static void taskA(){
        List<Pair<Animal, String>> animalsFavoriteDishes = new LinkedList<>();
        animalsFavoriteDishes.add(new Pair<>(new Animal("Тузик", "Собака"), "Кость"));
        animalsFavoriteDishes.add(new Pair<>(new Animal("Барсик", "Кошка"), "Вискас"));
        animalsFavoriteDishes.add(new Pair<>(new Animal("Эдгар Алан По", "Ворон"), "Зерно"));
        animalsFavoriteDishes.add(new Pair<>(new Animal("Вилли", "Касатка"), "Рыба"));

        Animal.feedAnimals(animalsFavoriteDishes);
    }

    public static void taskB(){
        gasolyne();
        mobileApps();
    }

    private static void gasolyne(){
        final int STATION_COUNT = 10;
        Random random = new Random();
        List<Triple<String, GasolineType, Double>> gasStations = new LinkedList<>();
        for(int i=0; i<STATION_COUNT; i++){
            String stationName = "Заправка "+i;
            for(GasolineType gasolineType: GasolineType.values()){
                Triple<String, GasolineType, Double> triple = new Triple<>(stationName, gasolineType, 100*random.nextDouble());
                gasStations.add(triple);
            }
        }
        System.out.println(gasStations);
        for(GasolineType gasolineType: GasolineType.values()){
            GasolineType.findBestPrice(gasStations, gasolineType);
        }
    }

    private static void mobileApps(){
        final int APPS_COUNT = 10;
        List<Triple<String, Double, Double>> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<APPS_COUNT; i++){
            list.add(new Triple<>("Приложение "+i, 1000*random.nextDouble(), 10*random.nextDouble()));
        }
        MobileApps.rangeToGradesCount(list);
        MobileApps.betterRating(list);
        MobileApps.worstRating(list);
    }
}
