package task6.b;

import task6.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainAppList {
    public static void main(String[] args) {
        List<Triple<String, Double, Double>> apps = new ArrayList<>();

        Triple<String, Double, Double> app1 = new Triple<>("app1", 100.0, 3.4);
        Triple<String, Double, Double> app2 = new Triple<>("app2", 95.0, 4.4);
        Triple<String, Double, Double> app3 = new Triple<>("app3", 50.0, 4.8);
        Triple<String, Double, Double> app4 = new Triple<>("app4", 1.0, 5.0);
        Triple<String, Double, Double> app5 = new Triple<>("app5", 60.0, 2.1);

        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        apps.add(app4);
        apps.add(app5);

        System.out.println(sortByAmountOfReview(apps));
        System.out.println(getAppWithBestRating(apps));
        System.out.println(getAppWithLessRating(apps));
    }

    private static List<Triple<String, Double, Double>> sortByAmountOfReview(List<Triple<String, Double, Double>> apps) {
        List<Triple<String, Double, Double>> triples = apps.stream().sorted(Comparator.comparingDouble(Triple::getSecond))
                .collect(Collectors.toList());
        return triples;
    }

    private static String getAppWithBestRating(List<Triple<String, Double, Double>> apps) {
        return apps.stream().max(Comparator.comparingDouble(Triple::getThird)).toString();
    }

    private static String getAppWithLessRating(List<Triple<String, Double, Double>> apps) {
        return apps.stream().min(Comparator.comparingDouble(Triple::getThird)).toString();
    }
}
