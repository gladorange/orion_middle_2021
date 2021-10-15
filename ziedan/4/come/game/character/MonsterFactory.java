package come.game.character;

public class MonsterFactory extends AbstractCharacterFactory {

    public static class Monster extends Character {
        private static final int DAMAGE_AMOUNT = 10;

        public Monster(String name) {
            super(name);
        }


        @Override
        public void attack(Character character) {
            character.getAttackedBy(DAMAGE_AMOUNT);
            System.out.printf("<%s> has been attacked by Monster <%s>%n", this.name, character.getName());
        }
    }

    @Override
    public Character makeCharacter(String name) {
        return new Monster(name);
    }
}
