package task7.fooditems;

import task7.Randomizer;

import java.util.Collection;

public class AppleGarden {

    public void fillShopWithApples(Collection<? super Apple> items) {
        int randomInt = Randomizer.generate(5 , 10);
        for(int i = 0; i < randomInt; i++){
            items.add(new Apple(getRandomColor()));

        }
        System.out.println("Items added to the Store");
        items.forEach(System.out::println);

    }

    public static String getRandomColor() {
        int randomInt = Randomizer.generate(1, 3);
        String result;
        switch(randomInt) {
            case 1 :  result = "red";
            break;
            case 2 : result = "green";
            break;
            case 3 : result = "yellow";
            break;
            default: result = "rgb";
        }
        return result;
    }
}
