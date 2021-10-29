package lection7.task1.items;

/**
 * Дополнительное свойство -  громкость (soundVolume).
 */
public class TV extends ElectronicItem{
    private final Integer soundVolume;

    public TV(String name, Double price, Double powerConsumption, Integer soundVolume) {
        super(name, price, powerConsumption);
        this.soundVolume = soundVolume;
    }

    public Integer getSoundVolume() {
        return soundVolume;
    }
}
