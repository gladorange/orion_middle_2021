package lection7.task1.items;

/**
 * дополнительное поле потребляемая мощность (powerConsumption).
 * мощность будем исчислять в Ваттах
 */
public abstract class ElectronicItem extends ShopItem{
    private final Double powerConsumption;

    public ElectronicItem(String name, Double price, Double powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("мощность:%.2fВт, ", powerConsumption);
    }
}
