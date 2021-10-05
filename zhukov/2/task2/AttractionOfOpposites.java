package task2;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class AttractionOfOpposites {

    public static void main(String[] args)
    {
        int[] array = getRandomArrayBySize(10,Integer.MIN_VALUE,Integer.MAX_VALUE);

        showArray(array);

        for (int j=0, i=1; i< array.length; j++,i++) {

            if( areNumbersSignsDiff( array[j] , array[i] )  ){
                System.out.printf("Числа с противоположными знаками обнаружены: %s %s \n",  array[j],array[i] );
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

    private static void showArray(int[] array)
    {
        System.out.printf("%s \n", Arrays.toString(array) );
    }

    private static int getRandomNumberInRange(int from, int to)
    {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private static boolean areNumbersSignsDiff(int first, int second)
    {
        // number's height limits
        final int EQUALIZER = 1_000_000;

        double sum = (double)first/EQUALIZER * (double)second/EQUALIZER;
        return   sum < 0 ;
    }
}
