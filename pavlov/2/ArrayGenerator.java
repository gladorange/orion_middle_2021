import java.util.Random;

public class ArrayGenerator {
    static int[] generateRandomNumbers(int max, int min, int arrayLength){
        Random random = new Random();
        return random
                .ints(arrayLength, min, max)
                .toArray();
    }
}
