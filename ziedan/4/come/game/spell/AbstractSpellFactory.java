package come.game.spell;

public abstract class AbstractSpellFactory {

    public abstract static class Spell {
        protected String name;

        public Spell() {

        }

        public abstract void cast();
    }

    public abstract Spell makeSpell();
}
