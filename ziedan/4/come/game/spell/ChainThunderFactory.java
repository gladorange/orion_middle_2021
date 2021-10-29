package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class ChainThunderFactory extends AbstractSpellFactory {

    public static class ChainThunder extends Spell {
        private static final int DAMAGE = 10;
        public ChainThunder(MagicianFactory.Magician magician) {
            super("Цепная молния", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            List<String> attacked = new ArrayList<>();
            AbstractCharacterFactory.Character[] sceneCharacters = scene.getCharacters();
            for (AbstractCharacterFactory.Character sceneCharacter : sceneCharacters) {
                if (sceneCharacter != null && sceneCharacter.getPosition() != owner.getPosition()) {
                    sceneCharacter.getAttackedBy(DAMAGE);
                    attacked.add(sceneCharacter.getName());
                }
            }
            logAttacked(attacked, DAMAGE);
        }
    }

    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new ChainThunder(magician);
    }
}
