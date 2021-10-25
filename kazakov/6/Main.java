import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

public class Main {

    enum RatingCriteriaType {LOWEST, HIGHEST, AVERAGE}
    enum GasolineType {DIESEL, AI_92, AI_95, AI_98, AI_100}
    enum ActivityType {POET, ARTIST, SCIENTIST, ENGINEER, ARCHITECT, THEORIST, ANATOMIST}

    //  Создайте метод feedAnimals(List<Pair<Animal,String>>);
    public static void feedAnimals(List<Pair<Animal, String>> list) {
        /*
        Для каждого животного выводится надпись:
        "Животное %ИМЯ с радостью съедает %БЛЮДО
         */
        for (Pair<Animal, String> item : list) {
            System.out.printf("Животное %s с радостью съедает %s\n", item.getFirst().getName(), item.getSecond());
        }
        /*
        + в этом методе сгенерируйте случайное число от 0 до размера списка с животными.
                Это - номер животного, которое сегодня получит двойною порцию любимой еды.
        Для такого животного выведите надпись
        "Счастливое животное %имя получает двойную порцию %БЛЮДО"
        */
        Pair<Animal, String> item = list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
        System.out.printf("Счастливое животное %s получает двойную порцию: %s\n", item.getFirst().getName(), item.getSecond());
    }

    /*
    Создайте метод findBestPrice(List<Triple<String,GasolineType,Double>> list,GasolineType type ) который выводит на экран
    адрес бензоколонки с самой маленькой ценой на переданный тип бензина
    */
    public static void findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType petrol) {

        Optional<Triple<String, GasolineType, Double>> price = list
                .stream()
                .filter(x -> x.getSecond() == petrol)
                .min(Comparator.comparing(Triple::getThird));
        if (price.isPresent()) {
            System.out.printf("Адрес бензоколонки: %s  с мин.ценой: %.2f на сорт бензина: %s\n", price.get().getFirst(), price.get().getThird(), petrol);
        } else {
            System.out.printf("Бензоколонка на сорт бензина: %s не найдена.\n", petrol);
        }
    }

    /**
     * создайте функции, которые на вход принимают этот список и выводят:
     * - Все приложения, отсортированные по количеству оценок
     *
     * @return list of apps sorted by their rating
     */
    public static List<Triple<String, Double, Double>> sortAppsByRating(List<Triple<String, Double, Double>> list) {

        return list.stream()
                .sorted(Comparator.comparing(Triple::getThird))
                .collect(toList());
    }

    /**
     * - Приложение на основе типа рейтинга (попробовал объединить, чтобы не писать 2 разных ф-ии с max/min):
     *
     * @return app with best rating Triple<String, Double, Double>
     */
    public static Triple<String, Double, Double> getAppWithRating(List<Triple<String, Double, Double>> list, RatingCriteriaType criteria) {
        if (criteria == RatingCriteriaType.HIGHEST)
        return list.stream()
                .max(Comparator.comparing(Triple::getThird))
                .orElse(null);
        else  if (criteria == RatingCriteriaType.LOWEST)
            return list.stream()
                    .min(Comparator.comparing(Triple::getThird))
                    .orElse(null);
        return null;
    }

    public static void main(String[] args) {

        Pair<String, Integer> lastNameToAge = new Pair<>("Пупкин", 18);
        String lastName = lastNameToAge.getFirst();
        Integer age = lastNameToAge.getSecond();
        System.out.printf("<%s> : %d\n", lastName, age);

        Pair<String, List<String>> lastNameToPhoneNumbers = new Pair<>("Пупкин", Arrays.asList("+7 831 2112233", "+7 920 000 22 22"));
        lastName = lastNameToPhoneNumbers.getFirst();
        List<String> phoneNumbers = lastNameToPhoneNumbers.getSecond();
        System.out.printf("<%s> : %s\n", lastName, phoneNumbers);

        //  Аналогично  с Triple, только параметра типа и параметров констркторов должно быть 3.
        Triple<String, ActivityType, String> personPushkin = new Triple<>("А.С. Пушкин", ActivityType.POET, "Евгений Онегин");
        System.out.printf("'%s' деятельность: '%s' произведение: '%s'\n", personPushkin.getFirst(), personPushkin.getSecond(), personPushkin.getThird());
        //
        Triple<String, String, List<ActivityType>> personDaVinci =
                new Triple<>("Leonardo da Vinci", "Italian", Arrays.asList(ActivityType.ARTIST, ActivityType.SCIENTIST, ActivityType.ENGINEER, ActivityType.ARCHITECT, ActivityType.THEORIST, ActivityType.ANATOMIST));
        List<ActivityType> activities = personDaVinci.getThird();
        System.out.printf("'%s' : %s\n", personDaVinci.getFirst(), activities);

        /*
        Задание А. Работа с парами:
                Создайте класс Animal с полями имя(String) и тип животного (тоже String)
                Создайте список, состоящий из нескольких пар: животное и любимое блюдо(String) этого животного.
                //  Создайте список, состоящий из нескольких пар: животное и любимое блюдо(String) этого животного.
        */
        Pair<Animal, String> catMealPair = new Pair<>(new Animal("Кот", "Семейство Кошачьи"), "Вискас");
        Pair<Animal, String> dogMealPair = new Pair<>(new Animal("Пёс", "Семейство Псовые"), "Pedigree");
        Pair<Animal, String> cowMealPair = new Pair<>(new Animal("Корова", "Семейство Полорогие"), "Трава");
        Pair<Animal, String> foxMealPair = new Pair<>(new Animal("Лиса", "Семейство Псовые"), "Мышь");
        List<Pair<Animal, String>> pairAnimalMealList = new ArrayList<>(Arrays.asList(catMealPair, dogMealPair, cowMealPair, foxMealPair));
        //  Создайте метод feedAnimals(List<Pair<Animal,String>>);
        feedAnimals(pairAnimalMealList);

       /*
        Задание Б. Списки, списки...
        Сейчас будем выводить разные списки и как-то их обрабатывать:

        Список с бензоколонками и ценами на бензин.
                Цены хранятся в списке троек:
        - Адрес бензоколонки - строка
                - Тип бензина - enum, возможные значения: ДТ, АИ-92, АИ-95, АИ-98
                - Цена - double
        */
        Triple<String, GasolineType, Double> atMiraGasStation = new Triple<>("Проспект Мира д.101", GasolineType.AI_95, 45.50);
        Triple<String, GasolineType, Double> onRoadPetrolStation = new Triple<>("Придорожная ул. д.3", GasolineType.DIESEL, 45.50);
        Triple<String, GasolineType, Double> nearHomeGasStation = new Triple<>("Котельникова ул. 44-100", GasolineType.AI_92, 42.99);
        Triple<String, GasolineType, Double> luxuriousGasStation = new Triple<>("Колмогорова д.5", GasolineType.AI_98, 53.99);
        Triple<String, GasolineType, Double> atNearestTurnGasStation = new Triple<>("Рихарда Зорге д.39", GasolineType.AI_92, 42.50);
        Triple<String, GasolineType, Double> kremlinGasStation = new Triple<>("Кремлёвская д.42", GasolineType.AI_92, 43.0);
        //  Создайте список List<Triple<String,GasolineType,Double>> и заполните его данными о нескольких бензоколоноках.
        List<Triple<String, GasolineType, Double>> gasStationsList =
                Arrays.asList(atMiraGasStation, onRoadPetrolStation, nearHomeGasStation, luxuriousGasStation, atNearestTurnGasStation, kremlinGasStation);
        //  ищем бензоколонку с минимальной ценой на АИ-92:
        findBestPrice(gasStationsList, GasolineType.AI_92);
        findBestPrice(gasStationsList, GasolineType.AI_100);

        /*
        Список приложений на телефон:
        Приложения хранятся в списке троек:
        - Название приложения - строка
                - Количество оценок - double
        - Средний рейтинг - double от 1 до 5.

        Создайте список List<Triple<String,Double,Double>>
        */
        List<Triple<String, Double, Double>> appList = new ArrayList<>();
        appList.add(new Triple<>("YouTube", 124e6, 4.3));
        appList.add(new Triple<>("TikTok", 41e6, 4.5));
        appList.add(new Triple<>("English Dictionary", 186e3, 4.8));
        appList.add(new Triple<>("Telegram", 8e6, 4.4));
        appList.add(new Triple<>("WhatsApp", 147e6, 4.1));
        /*
         * - Все приложения, отсортированные по количеству оценок
         */
        System.out.printf("Отсортированные приложения: %s\n", sortAppsByRating(appList));
        // Приложение с самым лучшим рейтингом
        System.out.printf("Приложение с максимальным рейтингом: %s\n", getAppWithRating(appList, RatingCriteriaType.HIGHEST));
        // Приложение с самым худшим  рейтингом
        System.out.printf("Приложение с минимальным рейтингом: %s\n", getAppWithRating(appList, RatingCriteriaType.LOWEST));
    }
}
