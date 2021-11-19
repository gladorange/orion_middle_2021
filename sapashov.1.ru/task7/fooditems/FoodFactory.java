package task7.fooditems;

import task7.Randomizer;

import java.util.Collection;

import static task7.fooditems.AppleGarden.getRandomColor;

public class FoodFactory {

    public void fillShopWithFood(Collection<? super FoodItem> items) {
        int randomInt = Randomizer.generate((items.size() / 2) , items.size());
        for(int i = 0; i < randomInt; i++){
            if(i % 2 == 0){
                items.add(new Bread(400));
            } else {
                items.add(new Apple(getRandomColor()));
            }

        }
        System.out.println("Items added to the Store");
        items.forEach(System.out::println);
    }
}
