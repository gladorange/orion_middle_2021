/*
Задание 2.
1.		Магия чисел.
		Создайте массив целых чисел на 100 элементов.
		Заполните их случайными числами от - 100 до 100.
		Создайте функцию boolean isMagicNumber(int number)
		Функция возвращает true, если число "магическое" - состоит из одинаковых цифр (например 22, или -33)
		Используя цикл for, проверьте каждое число в массиве, является ли оно "магическим".
		Если число "магическое" - выведите на экран надпись "Число <число> - магическое!"
 */
package ru.task2;
import java.util.Random;

public class MagicOfNumbers {

	static final int MAGIC_ARRAY_DIMENSION = 100;	//	random numbers array dimension
	static final int MAX_RANDOM = 100;	//	random numbers range (signed, inclusively)

	static final Random rand = new Random();
	static int getNextRandomIntWithBand() {
		return rand.nextInt() % (MAX_RANDOM + 1);	//	we must add 1 to a random band to include upper bound
	}

	/*	Функция возвращает true, если число "магическое" - состоит из одинаковых цифр (например 22, или -33)
	 *	Подсказка: для получения цифр числа можно использовать деление на 10 и остаток от деления на 10 (операция %)
	 */
	static boolean isMagicNumber(int number) {
		int digits_num = 0;

		if (number < 0) {	//	eliminate sign
			number  = -number;
		}
		int first_digit = number % 10;
		do {
			//System.out.printf("Число: <%d>; rem_mod10 = %d;\n", number, number % 10);
			if (number % 10 != first_digit) {
				return false;
			}
			number /= 10;
			digits_num++;
		} while (number > 0);
		return digits_num > 1;	//	magic number must contain total number of digits greater than one
	}

	public static void main(String[] args) {

		int [] MagicIntArray = new int [MAGIC_ARRAY_DIMENSION];
		for (int i = 0; i < MAGIC_ARRAY_DIMENSION; i++) {
			MagicIntArray[i] = getNextRandomIntWithBand ();
		}
		/*
		//	test for random numbers generation with specified range:
		int random_max_random;
		do {
			random_max_random = getNextRandomIntWithBand(MAX_RANDOM);
			System.out.printf("Число: %d\n", random_max_random);
		}	while (Math.abs(random_max_random) != MAX_RANDOM);
		System.out.printf("Число: <%d> - MAX_RANDOM!\n", random_max_random);
		 */
		for (int i = 0; i < MAGIC_ARRAY_DIMENSION; i++) {
			if (isMagicNumber(MagicIntArray[i]))
				System.out.printf("Number: <%d> is magic!\n", MagicIntArray[i]);
		}
	}
}
