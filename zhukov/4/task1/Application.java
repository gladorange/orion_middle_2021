package task1;

import task1.classes.MonsterFactory;
import task1.classes.Scene;
import task1.classes.WizardFactory;
import task1.enums.Factories;
import task1.interfaces.CharacterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    public static void main(String[] args) {


        Scene scene = new Scene();
        scene.fillScene();
    }
}
