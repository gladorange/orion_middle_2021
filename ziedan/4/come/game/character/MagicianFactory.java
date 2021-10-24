package come.game.character;

import come.game.scene.SceneFactory;
import come.game.spell.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicianFactory extends AbstractCharacterFactory {

    private static final String[] names = new String[]{
            "Strarune", "Iliviar", "Kolore", "Isorin", "Okius", "Zakore", "Elenor", "Ikron", "Axon", "Ulrelius"
    };
    public static class Magician extends Character {

        private List<AbstractSpellFactory.Spell> spells;

        public Magician(String name) {
            super(name);
        }

        @Override
        public void attack(SceneFactory.Scene scene) {
            Random random = new Random();
            AbstractSpellFactory.Spell spell = spells.get(random.nextInt(spells.size()));

            System.out.printf("Маг %s читает заклинание %s.%n", name, spell.getName());

            spell.cast(scene);

            scene.onAfterAttack();
        }

        public List<AbstractSpellFactory.Spell> getSpells() {
            return spells;
        }

        public void setSpells(List<AbstractSpellFactory.Spell> spells) {
            this.spells = spells;
        }

    }

    @Override
    public Character makeCharacter() {
        Random random = new Random();
        String name = names[random.nextInt(names.length)];
        Magician magician = new Magician(name);
        List<AbstractSpellFactory.Spell> spells = new ArrayList<>();
        do {
            AbstractSpellFactory factory;
            switch (random.nextInt(7)) {
                case 1:
                    factory = new BanishingMonstersFactory();
                    break;
                case 2:
                    factory = new ChainThunderFactory();
                    break;
                case 3:
                    factory = new FireTouchFactory();
                    break;
                case 4:
                    factory = new FireWallFactory();
                    break;
                case 5:
                    factory = new MigraineFactory();
                    break;
                case 6:
                    factory = new ThunderSpellFactory();
                    break;
                default:
                    factory = new HealingSpellFactory();
                    break;
            }
            spells.add(factory.makeSpell(magician));
        } while (random.nextBoolean());
        magician.setSpells(spells);
        return magician;
    }
}
