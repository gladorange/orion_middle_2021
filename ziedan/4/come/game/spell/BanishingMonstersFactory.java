package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.character.MonsterFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class BanishingMonstersFactory extends AbstractSpellFactory {

    public static class BanishingMonsters extends Spell {

        private static final int DAMAGE = 10;

        public BanishingMonsters(MagicianFactory.Magician magician) {
            super("Изгнание монстров", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            List<String> attacked = new ArrayList<>();
            for (AbstractCharacterFactory.Character character : scene.getCharacters()) {
                if (character instanceof MonsterFactory.Monster) {
                    attacked.add(character.getName());
                    character.getAttackedBy(DAMAGE);
                }
            }
            logAttacked(attacked, DAMAGE);
        }
    }

    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new BanishingMonsters(magician);
    }
}
