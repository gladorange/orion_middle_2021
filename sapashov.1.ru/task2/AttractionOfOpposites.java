package task2;

import java.util.concurrent.ThreadLocalRandom;

public class AttractionOfOpposites {

    public static void main(String[] args) {

        int[] array = createArray(10);

        findNumbersWithOppositeSigns(array);

    }

    private static void findNumbersWithOppositeSigns(int[] array) {
        for(int i = 1; i < array.length; i++) {
            if(array[i] > 0 & array[i - 1] < 0) {
                System.out.printf("%nNumbers with opposite signs are detected: %s %s", array[i], array[i - 1]);
            }
            if(array[i] < 0 & array[i - 1] > 0) {
                System.out.printf("%nNumbers with opposite signs are detected: %s %s", array[i], array[i - 1]);
            }
        }
    }

    private static int[] createArray(int size) {

        int[] array = new int[size];

        for(int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return array;
    }
}
