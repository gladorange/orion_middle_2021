package task2;
//Домашнее задание к лекции 2
//Задание 2. Влечение противоположностей
//Салмов Евгений

public class Task2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        long longNum = 2_147_483_647;
        longNum *= 2;
        longNum += 1;
        //заполним массив случайными числами от -2_147_483_648 до 2_147_483_647
        for(int i=0; i<arr.length; i++){
            long longNum2 = (long) (Math.random()*longNum);
            arr[i] = (int) (longNum2 - longNum);
        }

        //Выведем массив на экран
        System.out.print("массив [");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]);
            if(j != (arr.length-1)){
                System.out.print(", ");
            }
        }
        System.out.println("]\n");

        //Проверим, есть ли в соседних элементах числа с разными знаками
        for (int j = 0; j < (arr.length-1); j++) {
            if((arr[j]>0 && arr[j+1]<0) ||
                    (arr[j]<0 && arr[j+1]>0)) {
                System.out.println("Числа с противоположными знаками обнаружены: " + arr[j] + " " + arr[j+1]);
            }
        }
    }


}
