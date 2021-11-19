package task1.classes;

public class Refrigerator extends ShopItem.ElectronicItem{

    Integer volume;
    Refrigerator(String title, Double price, Double powerConsumption, Integer volume) {
        super(title, price, powerConsumption);
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Рефрижератор " +  getTitle() ;
    }
}
