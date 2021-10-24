package come.game.character;

import come.game.scene.SceneFactory;

import java.util.Random;

public class MonsterFactory extends AbstractCharacterFactory {
    private static final String[] names = new String[]{
            "Gutling",
            "Banehand",
            "Horrorbeing",
            "Taintbeing",
            "The Ancient Hybrid",
            "The Eternal Freak",
            "The Defiant Howler",
            "The White-Eyed Phantom Leviathan",
            "The Bright Storm Rhino",
            "The Iron Tomb Cat",
    };

    public static class Monster extends Character {
        private static final int DAMAGE_AMOUNT = 10;

        public Monster(String name) {
            super(name);
        }


        @Override
        public void attack(SceneFactory.Scene scene) {
            Character[] characters = scene.getCharacters();
            for (Character character : characters) {
                if (character != null && (character.getPosition() == position + 1 || character.getPosition() == position -1)) {
                    System.out.printf("<%s> has been attacked by Monster <%s>%n", this.name, character.getName());
                }
            }

            scene.onAfterAttack();
        }
    }

    @Override
    public Character makeCharacter() {
        Random random = new Random();
        String name = names[random.nextInt(names.length)];
        return new Monster(name);
    }
}
