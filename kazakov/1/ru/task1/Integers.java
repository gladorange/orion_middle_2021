package ru.task1;
public class Integers {

	public static void main(String[] args) {
		Integer val1 = 1;
		Integer val2 = -1000;

		System.out.println("Hello World!");
		if( val1 > val2 ) {
			System.out.printf("Число %s больше чем %s\n", val1, val2);
		} else if( val1 < val2 ) {
			System.out.printf("Число %s меньше чем %s\n", val1, val2);
		} else {
			System.out.printf("Числа %s и %s равны\n", val1, val2);
		}
		System.out.printf("Сумма двух чисел: %s", val1 + val2);
	}
}
