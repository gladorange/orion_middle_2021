package lection7.task1.items;

/**
 * Дополнительное свойство - объем морозильной камеры (freezerVolume).
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
}
