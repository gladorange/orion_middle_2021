package task2;


import java.util.concurrent.ThreadLocalRandom;

public class NumbersMagic {

    public static void main(String[] args) {

        int[] array = createArray();

        magicCheck(array);
    }

    private static void magicCheck(int[] array) {
        for(int i : array) {
            if(isMagicNumber(i)) {
                System.out.printf("%nNumber %s - magic number.", i);
            }
        }
    }

    private static int[] createArray() {
        int size = 100;
        int[] array = new int[size];

        int min = -100;
        int max = 100;

        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        return array;
    }

    private static boolean isMagicNumber(int num) {
        if(num == 0) {
            return false;
        }
        return num / 10 == num % 10;
    }
}
