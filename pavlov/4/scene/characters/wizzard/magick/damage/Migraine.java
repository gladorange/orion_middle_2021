package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

import java.util.Arrays;

public class Migraine extends DamageSpell {

    public Migraine(int power) {
        super("Мигрень", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        Character[] enemies = scene.getEnemies(wizzard);
        return Arrays.stream(enemies)
                .filter(character -> character instanceof Wizzard)
                .toArray(Character[]::new);
    }
}
