package come.game;

import come.game.character.AbstractCharacterFactory;
import come.game.scene.SceneFactory;

import java.util.Random;

public class Simulator {

    private final SceneFactory.Scene scene;

    public Simulator(SceneFactory.Scene scene) {
        this.scene = scene;
    }

    public void simulateRandomAttack() {
        Random random = new Random();
        AbstractCharacterFactory.Character[] characters = scene.getCharacters();
        AbstractCharacterFactory.Character character = characters[random.nextInt(characters.length)];
        if (character == null) {
            simulateRandomAttack();
        } else {
            character.attack(scene);
        }
    }

    public boolean isGameOver() {
        int countAlive = 0;
        for (AbstractCharacterFactory.Character character : scene.getCharacters()) {
            if (character != null && !character.isDead()) {
                countAlive++;
            }
            if (countAlive > 1) {
                return false;
            }
        }
        return true;
    }

}
