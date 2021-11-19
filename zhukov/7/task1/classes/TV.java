package task1.classes;

public class TV extends ShopItem.ElectronicItem{

    private Integer volume ;

    TV(String title, Double price, Double powerConsumption,Integer volume) {
        super(title, price, powerConsumption);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Телевизор " +this.getTitle() ;
    }
}
