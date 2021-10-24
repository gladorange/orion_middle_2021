package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class ThunderSpellFactory extends AbstractSpellFactory {


    public static class ThunderSpell extends Spell {
        private static final int DAMAGE_POWER = 5;

        public ThunderSpell(MagicianFactory.Magician magician) {
            super("Молния", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            AbstractCharacterFactory.Character[] characters = scene.getCharacters();
            for (AbstractCharacterFactory.Character character : characters) {
                character.getAttackedBy(DAMAGE_POWER);
            }
            System.out.printf("Молния ударила всех. Каждый получает %s урона.", DAMAGE_POWER);
        }
    }

    @Override
    public Spell makeSpell(MagicianFactory.Magician mag) {
        return new ThunderSpell(mag);
    }
}
