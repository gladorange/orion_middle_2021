package task1;
//Домашнее задание к лекции 2
//Задание 1. Магия чисел
//Салмов Евгений

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        //заполним массив случайными числами от -100 до 100
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) (Math.random()*(200+1)) - 100;
        }
        //Проверим, есть ли в массиве "магические" числа
        for (int i: arr) {
            if(isMagicNumber(i)){
                System.out.printf("Число %s - магическое!\n",i);
            }
        }
    }

    public static boolean isMagicNumber(int number) {
        return (number / 10) == (number % 10);
    }
}
