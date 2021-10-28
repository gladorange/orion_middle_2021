package items.electronic;

import java.util.Objects;

public class Refrigerator extends ElectronicItem {
    private final int freezerVolume;

    public Refrigerator(String name, int price, int powerConsumption, int freezerVolume) {
        super(name, price, powerConsumption);
        this.freezerVolume = freezerVolume;
    }

    public int getFreezerVolume() {
        return freezerVolume;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "freezerVolume=" + freezerVolume +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerator that = (Refrigerator) o;
        return freezerVolume == that.freezerVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), freezerVolume);
    }
}
