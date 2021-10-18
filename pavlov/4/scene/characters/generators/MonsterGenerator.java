package scene.characters.generators;

import scene.characters.Character;
import scene.characters.Monster;
import scene.characters.generators.AbstractCharacterGenerator;
import scene.characters.generators.IGenerator;

public class MonsterGenerator extends AbstractCharacterGenerator {
    private IGenerator<Integer> damageGenerator;

    public MonsterGenerator(IGenerator<Integer> healthGenerator, IGenerator<String> nameGenerator, IGenerator<Integer> damageGenerator) {
        super(healthGenerator, nameGenerator);
        this.damageGenerator = damageGenerator;
    }

    public IGenerator<Integer> getDamageGenerator() {
        return damageGenerator;
    }

    @Override
    public Character make() {
        int health = getHealthGenerator().make();
        String name = getNameGenerator().make();
        int damage = getDamageGenerator().make();

        return new Monster(health, name, damage);
    }
}
