import java.util.Arrays;

public class App2 {

    public static void main(String[] args) {
        int[] arr = getRandomIntArray();

        System.out.println("Массив: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (i < (arr.length - 1) && isSignFlipped(arr[i], arr[i+1])) {
                System.out.printf("Числа с противоположными знаками обнаружены: %s %s \n", arr[i], arr[i+1]);
            }
        }

    }

    private static int[] getRandomIntArray() {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = getRandomInt();
        }
        return arr;
    }

    /**
     * return a random integer between -50 and 50
     * @return int
     */
    private static int getRandomInt() {
        return (int) ((Math.random() * 100) - 50);
    }

    private static boolean isSignFlipped(int a, int b) {
        return (a < 0 && b > 0) || (a > 0 && b < 0);
    }
}
