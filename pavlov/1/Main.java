import java.util.Scanner;

public class Main {

    public static int readInteger(String message){
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        int firstInteger = readInteger("Введите первое число:");
        int secondInteger = readInteger("Введите второе число:");

        if(firstInteger > secondInteger){
            System.out.printf("Число %s больше %s \n", firstInteger, secondInteger);
        }else if(firstInteger < secondInteger){
            System.out.printf("Число %s меньше %s \n", firstInteger, secondInteger);
        }

        long sum = firstInteger + secondInteger;

        System.out.printf("%s + %s = %s", firstInteger, secondInteger, sum);
    }
}
