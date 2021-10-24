package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class FireWallFactory extends AbstractSpellFactory {
    public static class FireWall extends Spell {

        private static final int DAMAGE = 8;

        public FireWall(MagicianFactory.Magician magician) {
            super("Стена огня", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            List<String> attacked = new ArrayList<>();

            for (AbstractCharacterFactory.Character character : scene.getCharacters()) {
                if (character != null && character.getPosition() % 2 == 0) {
                    character.getAttackedBy(DAMAGE);
                    attacked.add(character.getName());
                }
            }

            logAttacked(attacked, DAMAGE);
        }
    }
    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new FireWall(magician);
    }
}
