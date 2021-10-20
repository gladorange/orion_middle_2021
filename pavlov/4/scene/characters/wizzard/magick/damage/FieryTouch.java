package scene.characters.wizzard.magick.damage;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FieryTouch extends DamageSpell {

    public FieryTouch(int power) {
        super("Огненное касание", power);
    }

    @Override
    protected Character[] selectTargets(Wizzard wizzard, Scene scene) {
        int wizzardPosition = scene.getPosition(wizzard);
        return IntStream.of(wizzardPosition-1, wizzardPosition+1)
                .filter(targetPosition -> targetPosition>0 && targetPosition<scene.maxCharacters())
                .filter(scene::hasCharacter)
                .mapToObj(scene::getCharacter)
                .toArray(Character[]::new);
    }
}
