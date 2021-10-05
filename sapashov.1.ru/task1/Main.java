package task1;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int first = random.nextInt(10);
        int second = random.nextInt(10);
        int sum = first + second;

        if (first > second) {
            System.out.printf("Number %s is greater than %s", first, second);
        }

        if (second > first) {
            System.out.printf("Number %s is less than %s", first, second);
        }

        System.out.println("\nSum of numbers is: " + sum);
    }
}
