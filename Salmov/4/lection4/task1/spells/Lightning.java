package lection4.task1.spells;
import lection4.task1.Helper;
import lection4.task1.characters.Character;

import java.util.Random;

/**
 Молния - наносит урон любому персонажу.
 */
public class Lightning extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    public Lightning(){
        super((new Random()).nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS);
        setName("Молния");
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        int identifiedTarget = Helper.identifyTarget(characters, spellCaster);
        int madeDamage = characters[identifiedTarget].spellCastedHandler(getEffectPoints());
        System.out.printf("%s ударяет по %s. Он получает %s урона.\n", getName(),
                characters[identifiedTarget].getName(), madeDamage);
    }

    @Override
    protected boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked) {
        return false;
    }
}
