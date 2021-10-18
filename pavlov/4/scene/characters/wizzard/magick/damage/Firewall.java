package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

import java.util.stream.IntStream;

public class Firewall extends DamageSpell {


    public Firewall(int power) {
        super("Стена огня", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        return IntStream.range(0, scene.maxCharacters())
                .filter(i -> i%2 == 0 && scene.hasCharacter(i) )
                .mapToObj(scene::getCharacter)
                .toArray(Character[]::new);
    }
}
