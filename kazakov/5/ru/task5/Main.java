package ru.task5;

import java.util.Scanner;

public class Main {
    //  define some constants for the game:
    //  кол-во позиций на сцене:
    final public static int SCENE_POSITIONS_NUM = 10;
    //  кол-во персонажей в игре (пропуск тоже считается за "фиктивный" персонаж):
    final public static int NUMBER_OF_CHARACTERS_WITH_EMPTY_CHARACTER = 3;
    //  первоначальное и МАКСИМАЛЬНОЕ кол-во здоровья для всех персонажей (чтобы не были "перекачанные"):
    final public static int CHARACTERS_MAX_HEALTH = 100;
    //  средний размер урона для монстров - связан с первоначальным размером здоровья:
    final public static int MONSTER_AVERAGE_DAMAGE = CHARACTERS_MAX_HEALTH / 5;
    //  максимальное отклонение от среднего урона для монстров:
    final public static int MONSTER_MAX_DEVIATION = 10;
    //  кол-во (размер списка) заклинаний для магов:
    final public static int WIZARD_BOOK_OF_SPELLS_MAX_CAPACITY = 3;

    public static void main(String[] args) {
        //  --- создаём сцену игры: ---
        final Scene scene = new Scene(SCENE_POSITIONS_NUM);
        /* для обработки событий клавиатуры в консоли используем решение:
         * https://stackoverflow.com/questions/27381021/detect-a-key-press-in-console
         */
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            /*
            Игра - пошаговая. В каждый ход все персонажи со сцены делают одно действие:
            монстр атакует кого-то, а маг читает любое известное ему заклинание.
             */
            //  делаем шаг в игре:
            scene.nextStep();
            // подсчитываем выживших на шаге:
            if (scene.getNumOfAlive() == 0) {
                System.out.printf("Игра ЗАВЕРШЕНА на шаге:[%d], ВЫЖИВШИХ НЕТ (ЧТО ПОДОЗРИТЕЛЬНО, ВОЗМОЖНО ОШИБКА)", scene.getStep());
                keyboard.close();
                return;
            }
            else if (scene.getNumOfAlive() == 1) {
                Character winner = scene.getWinner();
                System.out.println("=============================================================================");
                System.out.printf("Игра ЗАВЕРШЕНА за шагов: %d, ПОБЕДИЛ: <%s> на позиции:[%d], осталось здоровья:%s[%d%%]\n",
                        scene.getStep(), winner.toString(), winner.position, scene.getHealthInBars(winner.health), winner.health);
                keyboard.close();
                return;
            }
            //  2. проходимся по сцене и делаем перекличку живых персонажей:
            scene.passOverScene();
            //  обрабатываем пользовательский ввод с консоли:
            System.out.print("Нажмите в консоли 'Enter ↲' для следующего шага или 'q' и 'Enter ↲' для выхода из игры:");
            String input = keyboard.nextLine();
            if (input != null) {
                if (input.equals("q") || input.equals("Q") || input.equals("quit")) {
                    System.out.printf("Игра ПРЕРВАНА на шаге: %d, живых: %d, убито: %d", scene.getStep(), scene.getNumOfAlive(), scene.killed);
                    keyboard.close();
                    return;
                }
            }
        }
    }
}
