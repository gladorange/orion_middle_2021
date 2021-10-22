public class App1 {

    public static void main(String[] args) {
        int[] arr = new int[200];
        int j = 0;
        for (int i = -100; i < 100; i++) {
            arr[j] = i;
            j++;
        }
        for (int num : arr) {
            if (isMagicNumber(num)) {
                System.out.printf("Число %s - магическое!\n", num);
            }
        }
    }

    private static boolean isMagicNumber(int number) {
        return (number / 10) == (number % 10);
    }

}