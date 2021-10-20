package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

public class ChainLightning extends DamageSpell {

    public ChainLightning(int power) {
        super("Цепная молния", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        return scene.getEnemies(wizzard);
    }


}
