package task2;

import java.util.Arrays;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = random.nextInt();
        }

        System.out.println("Массив " + Arrays.toString(numbers));

        for (int i = 0; i < 9; i++) {
            if (isNextNumberOpposite(numbers[i], numbers[i+1]))
                System.out.println("Числа с противоположными знаками " +
                        "обнаружены: " + numbers[i] + " " + numbers[i+1]);
        }
    }

    public static boolean isNextNumberOpposite(int first, int second) {
        return (first > 0 && second < 0) || (first < 0 && second > 0);
    }
}
