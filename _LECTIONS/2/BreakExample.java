public class BreakExample {


    public static void main(String[] args) {

        int[] first = {1, 2, 3};
        int[] second = {1, 2, 3};

        outer_loop:
        for (int firstLetter : first) {
            for (int secondLetter : second) {
                final String currentNumber = firstLetter + "" + secondLetter;
                if (currentNumber.equals("23")) {
                    break outer_loop;
                }
                System.out.println(currentNumber);
            }
        }


        int size = 42;
        for (int i = 0; i < size; i++) {

        }

    }
}
