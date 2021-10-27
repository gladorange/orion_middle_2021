package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class MigraineFactory extends AbstractSpellFactory {

    public static class Migraine extends Spell {

        private static final int DAMAGE = 10;

        public Migraine(MagicianFactory.Magician magician) {
            super("Мигрень", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            List<String> attacked = new ArrayList<>();
            for (AbstractCharacterFactory.Character character : scene.getCharacters()) {
                if (character instanceof MagicianFactory.Magician) {
                    character.getAttackedBy(DAMAGE);
                    attacked.add(character.getName());
                }
            }
            logAttacked(attacked, DAMAGE);
        }
    }

    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new Migraine(magician);
    }
}
