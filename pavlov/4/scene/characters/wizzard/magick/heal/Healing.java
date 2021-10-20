package scene.characters.wizzard.magick.heal;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

public class Healing extends HealSpell {

    public Healing(int healingPower) {
        super("исцеление", healingPower);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        return new Character[]{wizzard};
    }


}
