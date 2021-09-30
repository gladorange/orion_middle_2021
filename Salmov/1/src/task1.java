//Домашнее задание к лекции 1
//Салмов Евгений

//import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        //значения переменных указаны в коде
        int intVar1 = 15;
        int intVar2 = 12;
        //значения переменных вводим с клавиатуры
        //для этого раскомментировать следующие 3 строки и строку импорта
        //Scanner myScan = new Scanner(System.in);
        //intVar1 = myScan.nextInt();
        //intVar2 = myScan.nextInt();

        //значения передаём как аргументы командной строки
        //для этого раскомментировать следующие 18 строк
        /*int i = 0;
        for (String str : args) {
            if(i==0) {
                try {
                    intVar1 = new Integer(str);
                    i++;
                }catch (NumberFormatException e) {
                    System.err.println("Неправильный формат строки!");
                }
            } else {
                try {
                    intVar2 = new Integer(str);
                    break;
                }catch (NumberFormatException e) {
                    System.err.println("Неправильный формат строки!");
                }
            }
        }*/

        if( intVar1 > intVar2 ) {
            System.out.printf("Число %s больше %s\n", intVar1, intVar2);
        } else if( intVar1 < intVar2 ) {
            System.out.printf("Число %s меньше %s\n", intVar1, intVar2);
        } else {
            System.out.printf("Числа %s и %s равны\n", intVar1, intVar2);
        }
        System.out.printf("Сумма чисел: %s", intVar1+intVar2);
    }
}
