package lection7.task1.items;

/**
 * Дополнительное свойство - объем морозильной камеры (freezerVolume).
 * Будем исчислять объём в литрах
 */
public class Refrigerator extends ElectronicItem{
    private final Integer freezerVolume;

    public Refrigerator(String name, Double price, Double powerConsumption, Integer freezerVolume) {
        super(name, price, powerConsumption);
        this.freezerVolume = freezerVolume;
    }

    public Integer getFreezerVolume() {
        return freezerVolume;
    }

    @Override
    public String getType() {
        return "Холодильник";
    }

    @Override
    public String toString() {
        return "Холодильник(" + super.toString() +
                "объём:" + freezerVolume + "л.)";
    }
}
