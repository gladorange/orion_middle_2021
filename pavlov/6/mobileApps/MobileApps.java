package mobileApps;

import corteges.Pair;
import corteges.Triple;

import java.util.*;

public class MobileApps {

    public static void rangeToGradesCount(List<Triple<String,Double,Double>> list){
        List<Triple<String, Double, Double>> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparingDouble(Pair::getSecond));
        for(Triple triple: sortedList){
            System.out.printf("%s, оценок: %s, средняя оценка: %s\n", triple.getFirst(), triple.getSecond(), triple.getThird());
        }

    }

    public static void worstRating(List<Triple<String,Double,Double>> list){
        Optional<Triple<String, Double, Double>> optional = list.stream().min(Comparator.comparingDouble(Triple::getThird));
        if(optional.isPresent()){
            Triple result = optional.get();
            System.out.println("Худшая оценка у приложения" + result.getFirst() + ", " + result.getThird());
        }
    }

    public static void betterRating(List<Triple<String,Double,Double>> list){
        Optional<Triple<String, Double, Double>> optional = list.stream().max(Comparator.comparingDouble(Triple::getThird));
        if(optional.isPresent()){
            Triple result = optional.get();
            System.out.println("Худшая оценка у приложения" + result.getFirst() + ", " + result.getThird());
        }
    }

    private MobileApps(){}
}
