package task1.classes;

public abstract class ShopItem {
    private String title;
    private Double price;

    public ShopItem(String title, Double price){
        this.title = title;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public abstract static class ElectronicItem extends ShopItem{

        final private Double powerConsumption ;

        ElectronicItem(String title, Double price, Double powerConsumption){
            super(title , price);
            this.powerConsumption = powerConsumption;
        }

        public Double getPowerConsumption() {
            return powerConsumption;
        }
    }

    public abstract static class FoodItem extends ShopItem{

        final private Integer caloric ;
        final private Integer expirationDays;

        FoodItem(String title, Double price, Integer caloric, Integer expirationDays){
            super(title , price);
            this.caloric = caloric;
            this.expirationDays = expirationDays;
        }

        public Integer getCaloric() {
            return caloric;
        }

        @Override
        public String getTitle() {
            return super.getTitle();
        }

        public Integer getExpirationDays() {
            return expirationDays;
        }

    }

}
