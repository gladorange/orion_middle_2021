package lection7.task1.items;

/**
 * дополнительное поле потребляемая мощность (powerConsumption).
 */
public class ElectronicItem extends ShopItem{
    private final Double powerConsumption;

    public ElectronicItem(String name, Double price, Double powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }
}
