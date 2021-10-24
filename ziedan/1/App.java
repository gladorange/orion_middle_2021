import java.util.Scanner;

public class App {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();

        if(a > b) {
            System.out.printf("Число %s больше %s \n", a, b);
        } else if (a < b) {
            System.out.printf("Число %s меньше %s \n", a, b);
        }
        System.out.printf("Сумма: %s", a + b);

    }
}