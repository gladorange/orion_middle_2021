package lection10.task1;
//Домашнее задание к лекции 10
//Файловый менеджер
//Салмов Евгений

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Примитивный файловый менеджер приветствует тебя!\n"+
                "Если хочешь ознакомиться с командами, введи команду help!\n"+
                "Для выхода из файлового менеджера используй команду exit!");
        CommandsHandler.handleCommands();
        System.out.println("Благодарю за использование! До новых встреч!");
    }
}
