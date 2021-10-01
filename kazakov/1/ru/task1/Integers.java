/*
	https://github.com/gladorange/orion_middle_2021/blob/main/_LECTIONS/1/home-work1.txt
	...
2. 	Написать программу, в которой есть две переменные типа Integer со значениями.
	Значения можно указать в коде программы или ввести с клавиатуры или взять из аргументов.
3. 	Если первое число больше второго – написать на экран « Число %s больше %s”
	Если первое число меньше второго – написать на экран «Число %s меньше %s”
4. 	В любом случае, вывести на экран сумму чисел.
*/
package ru.task1;

import java.util.Scanner;

public class Integers {

	public static void main(String[] args) {
		Integer val1;
		Integer val2;

		if (args.length >= 2) {
			System.out.printf("Есть аргументы программы (%dшт., '%s' и '%s')- работаем с аргументами.\n",
					args.length, args[0], args[1]);
			val1 = Integer.valueOf(args[0]);
			val2 = Integer.valueOf(args[1]);
		} else if (args.length == 1) {	//	мы должны предусмотреть все варианты :)
			//	первое число готово:
			val1 = Integer.valueOf(args[0]);
			try (Scanner myIntegerScanner = new Scanner(System.in)) {
				System.out.printf("Первое число - аргумент: %s, введите второе число: ", args[0]);
				val2 = myIntegerScanner.nextInt();  // Read val2
			} catch (Exception e) {
				System.out.println("Произошла ошибка при сканировании числа со стандартного ввода. Завершение работы программы.");
				return;
			}
		} else {
			try (Scanner myIntegerScanner = new Scanner(System.in)) {
				System.out.print("Введите первое число: ");
				val1 = myIntegerScanner.nextInt();  // Read val1
				System.out.print("Введите второе число: ");
				val2 = myIntegerScanner.nextInt();  // Read val2
			} catch (Exception e) {
				System.out.println("Произошла ошибка при сканировании числа со стандартного ввода. Завершение работы программы.");
				return;
			}
		}
		if (val1 > val2) {
			System.out.printf("Число %s больше чем %s\n", val1, val2);
		} else if (val1 < val2) {
			System.out.printf("Число %s меньше чем %s\n", val1, val2);
		} else {
			System.out.printf("Числа %s и %s равны\n", val1, val2);
		}
		System.out.printf("Сумма двух чисел: %s\n", val1 + val2);
	}
}
