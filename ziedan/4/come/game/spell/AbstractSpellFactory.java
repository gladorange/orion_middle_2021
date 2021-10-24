package come.game.spell;

import come.game.character.MagicianFactory;
import come.game.scene.SceneFactory;

import java.util.List;

public abstract class AbstractSpellFactory {

    public abstract static class Spell {
        protected String name;
        protected final MagicianFactory.Magician owner;

        public Spell(String name, MagicianFactory.Magician magician) {
            this.name = name;
            this.owner = magician;
        }


        public abstract void cast(SceneFactory.Scene scene);

        public String getName() {
            return name;
        }

        protected void logAttacked(List<String> attacked, int damage) {
            if (attacked.isEmpty()) {
                return;
            }
            System.out.printf("%s ударяет по %s. Каждый получает %s урона.%n",
                    name,
                    String.join(", ", attacked),
                    damage);
        }
    }

    public abstract Spell makeSpell(MagicianFactory.Magician magician);
}
