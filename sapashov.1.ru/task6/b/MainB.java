package task6.b;

import task6.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MainB {
    public static void main(String[] args) {

        List<Triple<String, GasolineType, Double>> gasStations = new ArrayList<>();
        Triple<String, GasolineType, Double> station1 = new Triple<>("address1", GasolineType.AI92, 100.00);
        Triple<String, GasolineType, Double> station2 = new Triple<>("address2", GasolineType.AI98, 150.00);
        Triple<String, GasolineType, Double> station3 = new Triple<>("address3", GasolineType.AI92, 120.00);
        Triple<String, GasolineType, Double> station4 = new Triple<>("address4", GasolineType.AI92, 120.00);
        Triple<String, GasolineType, Double> station5 = new Triple<>("address5", GasolineType.DIESEL, 125.00);
        Triple<String, GasolineType, Double> station6 = new Triple<>("address6", GasolineType.AI95, 130.00);
        Triple<String, GasolineType, Double> station7 = new Triple<>("address7", GasolineType.AI95, 135.00);

        gasStations.add(station1);
        gasStations.add(station2);
        gasStations.add(station3);
        gasStations.add(station4);
        gasStations.add(station5);
        gasStations.add(station6);
        gasStations.add(station7);

        System.out.println(findBestPrice(gasStations, GasolineType.AI92));
    }

    private static String findBestPrice(List<Triple<String, GasolineType, Double>> list, GasolineType gasolineType) {
        Triple<String, GasolineType, Double> stringGasolineTypeDoubleTriple = list.stream()
                .filter(o -> o.getSecond().equals(gasolineType))
                .min(Comparator.comparing(Triple::getThird))
                .orElseThrow(NoSuchElementException::new);

        return stringGasolineTypeDoubleTriple.getFirst();
    }


}
