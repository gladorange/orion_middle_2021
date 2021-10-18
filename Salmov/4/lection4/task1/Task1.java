package lection4.task1;
//Домашнее задание к лекции 4
//Битвы магов
//Салмов Евгений

public class Task1 {

    public static void main(String[] args) {
        Scene scene = new Scene();
        while (scene.getCharactersOnScene() > 1) {
            scene.nextStep();
        }
        scene.showWinner();
    }
}
