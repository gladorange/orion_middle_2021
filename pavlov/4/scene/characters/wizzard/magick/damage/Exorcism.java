package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.Monster;
import scene.characters.wizzard.Wizzard;

import java.util.Arrays;

public class Exorcism extends DamageSpell {

    public Exorcism(int power) {
        super("Изгнание монстров", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        Character[] enemies = scene.getEnemies(wizzard);
        return Arrays.stream(enemies)
                .filter(character -> character instanceof Monster)
                .toArray(Character[]::new);
    }


}
