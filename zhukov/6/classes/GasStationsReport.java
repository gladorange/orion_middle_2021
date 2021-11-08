package classes;

import enums.PetrolType;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GasStationsReport {

    final static String BEST_PRICE_TEXT = "Станция по адресу \"%s\" имеет лучшее предложение цены на бензин %s.\nСтоимость 1л - %s \n";

    public static void findBestPrice(List<Triple<String, PetrolType,Double>> list, PetrolType type ){
        list = list.stream()
                .filter(curEl-> Objects.equals(curEl.getSecond(), type ) )
                .collect(Collectors.toList());

        Triple<String,PetrolType,Double> station = Collections.min(list , Comparator
                .comparingDouble((Triple<String,PetrolType,Double> o)  -> o.getThird() )
        );
        System.out.printf(BEST_PRICE_TEXT,station.getFirst(),type.getName(),station.getThird());

    }
}
