package come.game.spell;

import come.game.character.MagicianFactory;

public class HealingSpellFactory extends AbstractSpellFactory {

    public static class HealingSpell extends Spell {

        MagicianFactory.Magician owner;
        private static final int HEALING_POWER = 30;

        public HealingSpell(MagicianFactory.Magician owner) {
            this.name = "Исцеление";
            this.owner = owner;
        }

        @Override
        public void cast() {
            this.owner.getHealedBy(HEALING_POWER);

        }

    }

    @Override
    public Spell makeSpell() {
        return null;
    }
}
