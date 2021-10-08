public class MagicNumbers {

    public static void main(String[] args) {
        int[] numbers = ArrayGenerator.generateRandomNumbers(100, -100, 100);
        checkForMagickNumbersAndPrintResult(numbers);
    }

    private static void checkForMagickNumbersAndPrintResult(int[] numbers){
        for(int number: numbers){
            if(isMagick(number)){
                System.out.printf("число %d - магическое!\n", number);
            }
        }
    }

    private static boolean isMagick(int number){
        number = Math.abs(number);
        int firstDigit = number % 10;
        while(number>0){
            int digit = number % 10;
            number = number / 10;
            if(digit != firstDigit){
                return false;
            }
        }
        return true;
    }
}
