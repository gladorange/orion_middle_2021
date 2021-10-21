package scene.characters.generators;

import scene.characters.Character;
import scene.characters.wizzard.Wizzard;
import scene.characters.wizzard.magick.Spell;

import java.util.stream.IntStream;

public class WiizzardGenerator extends AbstractCharacterGenerator {
    private IGenerator<Spell> spellGenerator;

    public WiizzardGenerator(IGenerator<Integer> healthGenerator, IGenerator<String> nameGenerator, IGenerator<Spell> spellGenerator) {
        super(healthGenerator, nameGenerator);
        this.spellGenerator = spellGenerator;
    }

    public IGenerator<Spell> getSpellGenerator() {
        return spellGenerator;
    }

    @Override
    public Character make() {
        int health = getHealthGenerator().make();
        String name = getNameGenerator().make();
        Spell[] spells = new Spell[Wizzard.MAX_SPELLS_SIZE];
        IntStream.range(0, spells.length)
                .forEach(i -> {
                    spells[i] = spellGenerator.make();
                });
        return new Wizzard(health, name, spells);
    }
}
