package come.game.spell;

import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

public class HealingSpellFactory extends AbstractSpellFactory {



    public static class HealingSpell extends Spell {

        private static final int HEALING_POWER = 30;

        public HealingSpell(MagicianFactory.Magician owner) {
            super("Исцеление", owner);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            owner.getHealedBy(HEALING_POWER);
        }

    }

    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new HealingSpell(magician);
    }
}
