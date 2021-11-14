package task7.electricitems;

import task7.electricitems.ElectronicItem;

public class TV extends ElectronicItem {
    private int volume;

    public TV(int powerConsumption) {
        super(powerConsumption);
    }

    @Override
    public String toString() {
        return "TV{" +
                "volume=" + volume +
                '}';
    }
}
