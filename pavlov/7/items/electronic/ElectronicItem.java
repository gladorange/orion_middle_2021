package items.electronic;

import items.ShopItem;

import java.util.Objects;

public abstract class ElectronicItem extends ShopItem {
    private final int powerConsumption;

    public ElectronicItem(String name, int price, int powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    @Override
    public String toString() {
        return "ElectronicItem{" +
                "powerConsumption=" + powerConsumption +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectronicItem that = (ElectronicItem) o;
        return powerConsumption == that.powerConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), powerConsumption);
    }
}
