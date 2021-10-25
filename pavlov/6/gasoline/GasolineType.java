package gasoline;

import corteges.Triple;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public enum GasolineType {
    Diesel("ДТ"),
    Gasoline92("АИ-92"),
    Gasoline95("АИ-95"),
    Gasoline98("АИ-98");

    private String name;

    GasolineType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void findBestPrice(List<Triple<String,GasolineType,Double>> list, GasolineType type){
        Optional<Triple<String, GasolineType, Double>> result = list.stream()
                .filter(triple -> triple.getSecond() == type)
                .min(Comparator.comparingDouble(Triple::getThird));
        if(result.isPresent()){
            Triple bestPriceGasStation = result.get();
            System.out.printf("На бензин %s самая лучшая цена на заправке %s (%s)\n",
                    type.getName(),
                    bestPriceGasStation.getFirst(),
                    bestPriceGasStation.getThird());
        }else{
            System.out.printf("Заправок с бензином: %s не найдено\n", type.getName());
        }
    }
}
