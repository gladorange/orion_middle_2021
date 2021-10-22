import java.math.BigDecimal;

public class FloatPointNumber {


    public static void main(String[] args) {
        double first = .1;
        double second = .2;

        System.out.println((first + second) == .3);


        BigDecimal one = BigDecimal.valueOf(.1);
        BigDecimal another = BigDecimal.valueOf(.2);


        final BigDecimal sum = one.add(another);
        System.out.println(BigDecimal.valueOf(.3).equals(sum));

    }
}
