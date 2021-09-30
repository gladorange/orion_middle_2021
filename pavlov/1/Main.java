import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int readInteger(String message){
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void calculateAndPrintResult(int firstInteger, int secondInteger){

        if(firstInteger > secondInteger){
            System.out.printf("Число %s больше %s \n", firstInteger, secondInteger);
        }else if(firstInteger < secondInteger){
            System.out.printf("Число %s меньше %s \n", firstInteger, secondInteger);
        }

        long sum = (long) firstInteger + secondInteger;

        System.out.printf("%s + %s = %s", firstInteger, secondInteger, sum);
    }

    public static void main(String[] args) {
        try {
            int firstInteger = readInteger("Введите первое число:");
            int secondInteger = readInteger("Введите второе число:");

            calculateAndPrintResult(firstInteger, secondInteger);
        } catch (InputMismatchException e){
            System.out.println("Введенное значение не является числом типа Integer");
        }
    }
}
