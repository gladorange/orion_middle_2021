/*
Задание 2.
2.		Влечение противоположностей
		-Создайте массив на 10 элементов
		-Заполните его случайными числами из всего диапазона int'a
		-Выведите все элементы массива на экран
---
		Теперь Проверьте все  "соседние" элементы массива (начинайте с 0 индекса и до самого конца).
		Если элементы разных знаков - то выведите на экран " Числа с противоположными знаками обнаружены: <Число1> <Число2>"
		Если одно из чисел 0 - то ничего не делайте.
		Выведите получившийся массив на экран.
---
		Например,
		массив [1,2,3,4,5,-7,2]
		Числа с противоположными знаками обнаружены: 5 -7
		Числа с противоположными знаками обнаружены: -7 2
 */
package ru.task2;
import java.util.Random;
/*
2.		Влечение противоположностей
 */
public class OppositesAttract {

	static final int OPPOSITES_ATTRACT_ARRAY_DIM = 10;	//	размерность массива случайных чисел
	static final Random rand = new Random();

	//	is sing changing (two numbers with opposite signs)?
	static boolean isSignChanging (int digitOne, int digitTwo) {
		if (digitOne > 0 && digitTwo < 0)
			return true;
		else if (digitOne < 0 && digitTwo > 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		/*
		-Создайте массив на 10 элементов
		-Заполните его случайными числами из всего диапазона int'a
		 */
		int [] OpposidesAttractArray = new int [OPPOSITES_ATTRACT_ARRAY_DIM];
		for (int i = 0; i < OPPOSITES_ATTRACT_ARRAY_DIM; i++) {
			OpposidesAttractArray[i] =  rand.nextInt();
		}
		/*
		-Выведите все элементы массива на экран
		 */
		for (int i = 0; i < OPPOSITES_ATTRACT_ARRAY_DIM; i++) {
				System.out.printf("элемент массива OpposidesAttractArray[%d]: %d\n", i, OpposidesAttractArray[i]);
		}
		/*
		Теперь Проверьте все  "соседние" элементы массива (начинайте с 0 индекса и до самого конца).
		Если элементы разных знаков - то выведите на экран " Числа с противоположными знаками обнаружены: <Число1> <Число2>"
		Если одно из чисел 0 - то ничего не делайте.
		Выведите получившийся массив на экран.
		Например,
		массив [1,2,3,4,5,-7,2]
		Числа с противоположными знаками обнаружены: 5 -7
		Числа с противоположными знаками обнаружены: -7 2
		 */
		int next_elem;
		for (int i = 0; i < OPPOSITES_ATTRACT_ARRAY_DIM; i++) {
			if (OpposidesAttractArray[i] == 0)	//	if one element is 0 then do nothing
				continue;
			//	get next element for current to compare:
			//	the next element for last element in array is a first element (circle compare)
			if (i == OPPOSITES_ATTRACT_ARRAY_DIM - 1)
				next_elem = OpposidesAttractArray[0];
			else
				next_elem =  OpposidesAttractArray[i + 1];
			if (next_elem == 0)	//	if one element is 0 then do nothing
				continue;
			//	compare signs of two elements:
			if (isSignChanging (OpposidesAttractArray[i],  next_elem)) {
				System.out.printf("Числа с противоположными знаками обнаружены: %d и %d\n",
						OpposidesAttractArray[i], next_elem);
			}
		}
	}
}
