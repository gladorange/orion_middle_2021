package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

import java.util.Random;

public class Lightning extends DamageSpell {

    public Lightning(int power) {
        super("Молния", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        Character[] enemies = scene.getEnemies(wizzard);

        Random random = new Random();
        return new Character[]{enemies[random.nextInt(enemies.length)]};
    }
}
