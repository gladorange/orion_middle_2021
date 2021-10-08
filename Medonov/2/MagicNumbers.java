import java.lang.reflect.Array;

public class MagicNumbers {
    public static void main(String[] arg) {
        int[] myIntArray = new int[100];
        fillArray(myIntArray);

        for (int i = 0; i < myIntArray.length; i++) {
            if (isMagicNumber(myIntArray[i])) {
                System.out.println(myIntArray[i]);
            }
        }
    }

    private static boolean isMagicNumber(int theN) {
        int aLast = (theN % 10) * -1;
        if (Math.abs(theN / 10) != aLast || theN == 0) {
            return false;
        } else {
            return true;
        }
    }

    private static int[] fillArray(int[] theArray) {

        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = randomNum(-100, 100);
        }
        return theArray;
    }

    private static int randomNum(int theMin, int theMax) {
        return theMin + (int) (Math.random() * ((theMax - theMin) + 1));
    }
}
