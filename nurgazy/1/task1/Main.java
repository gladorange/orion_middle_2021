package task1;

public class Main {

    public static void main(String[] args) {
        System.out.println(compareNumbers(5, 6));
        System.out.println(compareNumbers(7, 6));
    }


    public static String compareNumbers(Integer a, Integer b) {
        System.out.println(a+b);
        return (a > b) ? "Число " + a+ " больше " + b : "Число " + a + " меньше " + b;
    }
}
