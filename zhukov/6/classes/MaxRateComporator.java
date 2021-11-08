package classes;

import java.util.Comparator;
import java.util.Objects;

class MaxRateComparator implements Comparator<Triple<String,Double,Double>> {

    @Override
    public int compare( Triple<String,Double,Double> o1, Triple<String,Double,Double> o2) {
        int i =  (Objects.equals(o1.getThird() , o2.getThird()))
                ?(int) (o1.getSecond() - o2.getSecond())
                :(int) (o1.getThird() - o2.getThird());

        return i;
    }
}
