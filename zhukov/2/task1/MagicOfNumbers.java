package task1;
import java.util.concurrent.ThreadLocalRandom;

public class MagicOfNumbers {

    public static void main(String[] args)
    {
        int[] randomArray = getRandomArrayBySize(100 , -100,100);

        for (int value:randomArray) {
            if( isMagicNumber( value )){
                System.out.printf("Число %s - магическое!\n",value);
            }
        }
    }

    private static int[] getRandomArrayBySize( int size, int min, int max)
    {
        int[] randomArray = new int[size];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = getRandomNumberInRange(min,max);
        }
        return randomArray;
    }

    private static int getRandomNumberInRange(int from, int to)
    {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private static boolean isMagicNumber( int number)
    {
        if( number == 0 ) return false;

        return Math.abs(number%10) == Math.abs(number/10) ;
    }



}