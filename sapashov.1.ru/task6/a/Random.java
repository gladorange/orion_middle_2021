package task6.a;

public class Random {
    public static int getRandomInteger() {
        int min = 0;
        int max = 9;
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
