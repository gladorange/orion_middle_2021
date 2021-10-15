package come.game.character;

import come.game.spell.AbstractSpellFactory;

public class MagicianFactory extends AbstractCharacterFactory {

    public static class Magician extends Character {

        private final AbstractSpellFactory.Spell[] spells;

        public Magician(String name, AbstractSpellFactory.Spell[] spells) {
            super(name);
            this.spells = spells;
        }


        @Override
        public void attack(Character character) {

        }
    }

    @Override
    public Character makeCharacter(String name) {
        return null;
    }
}
