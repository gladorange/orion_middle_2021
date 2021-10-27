package come.game.spell;

import come.game.character.AbstractCharacterFactory;
import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class FireTouchFactory extends AbstractSpellFactory{
    public static class FireTouch extends Spell {

        private static final int DAMAGE = 6;

        public FireTouch(MagicianFactory.Magician magician) {
            super("Огненное касание", magician);
        }

        @Override
        public void cast(SceneFactory.Scene scene) {
            List<String> attacked = new ArrayList<>();
            AbstractCharacterFactory.Character[] sceneCharacters = scene.getCharacters();
            for (AbstractCharacterFactory.Character sceneCharacter : sceneCharacters) {
                if (sceneCharacter != null && (sceneCharacter.getPosition() == owner.getPosition() + 1 || sceneCharacter.getPosition() == owner.getPosition() - 1)) {
                    sceneCharacter.getAttackedBy(DAMAGE);
                    attacked.add(sceneCharacter.getName());
                }
            }
            logAttacked(attacked, DAMAGE);

        }
    }
    @Override
    public Spell makeSpell(MagicianFactory.Magician magician) {
        return new FireTouch(magician);
    }
}
