package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalCare {

    public static void feedAnimals(List<Pair<Animal, String>> list){

        List<Pair<Animal, String>> animalPairs = new ArrayList<>(list);
        final String DOUBLE_PORTION_TEXT = "Счастливое животное %s получает двойную порцию %s \n";
        final String SINGLE_PORTION_TEXT = "Животное %s с радостью съедает %s \n";
        int randPairIndex = ThreadLocalRandom.current().nextInt(0, animalPairs.size()  );


        Animal animal ;
        Pair randPair = animalPairs.get(randPairIndex) ;

        for (Pair pair:animalPairs) {

            animal = (Animal) pair.getFirst();
            String msgText = (pair.equals( randPair ))
                    ? DOUBLE_PORTION_TEXT
                    : SINGLE_PORTION_TEXT;

            System.out.printf( msgText,animal.getName() , pair.getSecond());
        }
    }
}
