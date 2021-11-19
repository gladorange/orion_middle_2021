package task7.electricitems;

import task7.ShopItem;

import java.util.Comparator;
import java.util.Objects;

public class ElectronicItem extends ShopItem implements Comparator<ElectronicItem>  {
    private int powerConsumption;


    public ElectronicItem(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public int compare(ElectronicItem o1, ElectronicItem o2) {
        return Integer.compare(o1.getPowerConsumption(), o2.getPowerConsumption());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicItem that = (ElectronicItem) o;
        return powerConsumption == that.powerConsumption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption);
    }

    @Override
    public String toString() {
        return "ElectronicItem{" +
                "powerConsumption=" + powerConsumption +
                '}';
    }
}
