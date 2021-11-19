package task7.electricitems;

public class Refrigerator extends ElectronicItem {
    private int volumeOfRef;

    public Refrigerator(int powerConsumption) {
        super(powerConsumption);
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "volumeOfRef=" + volumeOfRef +
                '}';
    }
}
