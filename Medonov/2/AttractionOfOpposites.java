import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.util.Random;

public class AttractionOfOpposites {
    public static void main(String[] arg) {
        int[] myIntArray = new int[10];
        fillArray(myIntArray);
        for (int i = 0; i < myIntArray.length; i++) {
            System.out.println(myIntArray[i]);
        }
        checkArgs(myIntArray);

    }

    private static void checkArgs(int[] theArray) {

        for (int i = 0; i < theArray.length - 1; i++) {
            if ((theArray[i] > 0 && theArray[i + 1] < 0) || (theArray[i] < 0 && theArray[i + 1] > 0)) {
                System.out.println(String.format("%nThe opposite numbers has been found: %s %s", theArray[i], theArray[i + 1]));
            }
        }
    }

    private static int[] fillArray(int[] theArray) {

        Random random = new Random();
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = random.nextInt();
        }
        return theArray;
    }
}
