package items.electronic;

import java.util.Objects;

public class TV extends ElectronicItem {
    private final int volume;

    public TV(String name, int price, int powerConsumption, int volume) {
        super(name, price, powerConsumption);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "TV{" +
                "volume=" + volume +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return volume == tv.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
