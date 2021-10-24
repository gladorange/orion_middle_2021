package ru.task1;

public class Comparator {
    public static void main(String[] args) {
        compare(1,2);
        compare(2,1);
        compare(2,2);
    }

    public static void compare(Integer first, Integer second){
        if (first>second){
            System.out.printf("Число %s больше %s \n",first,second);
        } else if (first<second) {
            System.out.printf("Число %s меньше %s \n",first,second);
        } else {
            System.out.print("Числа равны \n");
        }

        System.out.printf("Сумма %s и %s равна %s \n",first,second,first+second);
    }
}
