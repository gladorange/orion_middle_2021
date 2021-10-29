package come.game.scene;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.character.MonsterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SceneFactory {
    public static class Scene {
        private AbstractCharacterFactory.Character[] characters;


        public Scene(AbstractCharacterFactory.Character[] characters) {
            this.characters = characters;
        }


        public AbstractCharacterFactory.Character[] getCharacters() {
            return characters;
        }

        private void removeDeadCharacters() {
            List<Integer> deadPositions = new ArrayList<>();
            for (AbstractCharacterFactory.Character character : characters) {
                if (character != null && character.isDead()) {
                    deadPositions.add(character.getPosition());
                }
            }
            for (Integer deadPosition : deadPositions) {
                characters[deadPosition] = null;
            }
        }

        public void onAfterAttack() {
            removeDeadCharacters();
        }
    }

    public Scene makeScene() {
        AbstractCharacterFactory.Character[] characters = new AbstractCharacterFactory.Character[10];
        MagicianFactory magicianFactory = new MagicianFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Random random = new Random();

        for (int i = 0; i < characters.length; i++) {
            if (random.nextBoolean()) {
                characters[i] = monsterFactory.makeCharacter();
            } else {
                characters[i] = magicianFactory.makeCharacter();
            }
            characters[i].setPosition(i);
        }
        return new Scene(characters);
    }


}
