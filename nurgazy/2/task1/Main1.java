package task1;

import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        int numbers[] = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers[i] = random.nextInt(201) - 100;
        }

        for (int number : numbers) {
            if (isMagicNumber(number)) System.out.println("Число " + number + " - магическое!");
        }
    }

    public static boolean isMagicNumber(int number) {
        if (number > 0) return number%10 == number/10;
        if (number < 0) return isMagicNumber(Math.abs(number));
        return false;
    }
}
