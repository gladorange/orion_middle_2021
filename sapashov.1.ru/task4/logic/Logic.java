package task4.logic;

import task4.entity.Entity;
import task4.entity.characters.Mage;
import task4.entity.characters.Monster;
import task4.scene.Scene;

import java.util.*;

import static task4.utils.Random.getRandomInteger;

public class Logic {

    public Entity createCharacter(String command, String name) throws Exception {
        Entity entity = null;
        if (command.equals("1")) {
            System.out.println("new Mage created. His name is " + name);
            printLine();
            return createMage(name);
        }
        if (command.equals("2")) {
            System.out.println("new Monster created. His name is " + name);
            printLine();
            return createMonster(name);
        }
        if (!command.equals("1") && !command.equals("2")) {
            throw new Exception("Wrong command");

        }
        return entity;
    }

    public static void printLine() {
        System.out.println("=======================================");
    }

    public static void printMessage(String message) {
        printLine();
        System.out.println(message);
        printLine();

    }

    private Monster createMonster(String name) {
        return new Monster(name);
    }

    private Mage createMage(String name) {
        return new Mage(name);
    }

    public Scene creatingCharacters() {
        Scene scene = new Scene(new ArrayList<>(Collections.nCopies(10, null)));
        printLine();
        System.out.println("Welcome to the Game");
        System.out.println("To start game you have to create characters");
        printLine();
        while (true) {

            System.out.println("Type 1 and click Enter button to create Mage" +
                    "\nType 2 and click Enter to create monster");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("8")) {
                printLine();
                System.out.println("Game is Starting . . . ");
                printLine();
                break;
            }
            System.out.println("Please enter name of your character and press enter");
            String name = scanner.nextLine();
            printLine();
            System.out.println("To start game type 8 and Press Enter");
            printLine();
            try {
                if (command.equals("1")) {
                    Mage mage = createMage(name);
                    scene.addToScene(mage, new Random().nextInt(9));
                    System.out.println(scene.getScene());
                }
                if (command.equals("2")) {
                    Monster monster = createMonster(name);
                    scene.addToScene(monster, new Random().nextInt(9));
                    System.out.println(scene.getScene());
                }
            } catch (Exception e) {
                System.out.println("Wrong command, try again");
                printLine();
            }
        }
        return scene;
    }

    public void battle(Scene scene) {
        List<Entity> mainScene = scene.getScene();

        for (Entity entity : mainScene) {
            if (entity != null) {
                // show to console name of entity and then suggest choosing enemy
                printMessage("Your move " + entity.getName());
                // chose your enemy
                printMessage("Choose your enemy");
                for (int i = 0; i < mainScene.size(); i++) {

                    if (mainScene.get(i) != null && !mainScene.get(i).equals(entity)) {

                        printMessage("Enter " + i + " to attack " + mainScene.get(i).getName());

                    }

                }
                attackMove(entity, mainScene);

            }

        }
        Scene.healthCheck(mainScene);
    }

    public void attackMove(Entity entity, List<Entity> scene) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        printMessage("Enter your number: ");
        try {
            Entity entityToAttack = scene.get(Integer.parseInt(command));
            if (entity.getManaPoints() != 0) {
                Mage mage = (Mage) entity;
                int typeOfAction = getRandomInteger();

                switch (typeOfAction) {
                    case 0 -> mage.lightingAttack(entityToAttack);
                    case 1 -> mage.superLightingAttack(entityToAttack);
                    case 2 -> mage.fireballAttack(entityToAttack);
                    case 3 -> mage.superFireballAttack(entityToAttack);
                    case 4 -> mage.healSpell();
                    case 5 -> mage.hyperLightingAttack(entityToAttack);
                    case 6 -> mage.megaLightingAttack(entityToAttack);
                    case 7 -> mage.getManaSpell();
                    case 8 -> mage.hyperFireballAttack(entityToAttack);
                    case 9 -> mage.megaFireballAttack(entityToAttack);
                    default -> mage.attack(entityToAttack);
                }
            } else {
                entity.attack(entityToAttack);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
