package task4;

import task4.logic.Logic;
import task4.scene.Scene;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();

        Scene scene = logic.creatingCharacters();
        System.out.println("++++++++++++++++++++++++");
        while(true) {
            logic.battle(scene);
        }


    }
}
