import java.util.Arrays;

public class Opposites {
    public static void main(String[] args) {
        int[] numbers = ArrayGenerator.generateRandomNumbers(Integer.MAX_VALUE, Integer.MIN_VALUE, 10);
        System.out.println(Arrays.toString(numbers));
        findOppositesNeighborsAndPrint(numbers);
    }

    private static void findOppositesNeighborsAndPrint(int[] numbers){
        for(int i=0; i<numbers.length-1; i++){
            int j = i+1;
            if(Integer.signum(numbers[i]) != Integer.signum(numbers[j])){
                System.out.printf("Числа с противоположными знаками обнаружены: %d, %d\n", numbers[i], numbers[j]);
            }
        }
    }
}
