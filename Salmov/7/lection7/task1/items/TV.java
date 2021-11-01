package lection7.task1.items;

/**
 * Дополнительное свойство -  громкость (soundVolume).
 * Будем исчислять громксоть в абсолютных единицах "Сон"
 * 0 сон - порог слышымости, 128 сон - громкая музыка
 * 8 сон - шумная улица
 */
public class TV extends ElectronicItem{
    private final Double soundVolume;

    public TV(String name, Double price, Double powerConsumption, Double soundVolume) {
        super(name, price, powerConsumption);
        this.soundVolume = soundVolume;
    }

    public Double getSoundVolume() {
        return soundVolume;
    }

    @Override
    public String getType() {
        return "Телевизор";
    }

    @Override
    public String toString() {
        return "Телевизор(" + super.toString() +
                String.format("громкость:%.2fсон)", soundVolume);
    }
}
