package lection4.task1.spells;
import lection4.task1.characters.Character;
import lection4.task1.characters.Magician;
import lection4.task1.characters.Monster;

import java.util.Random;

/**
 Мигрень - наносит урон всем магам.
 */
public class Migraine extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    public Migraine(){
        super((new Random()).nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS);
        setName("Мигрень");
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        castMultiTarget(characters, spellCaster);
    }

    @Override
    protected boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked) {
        return (characterChecked != null && !(spellCaster.equals(characterChecked)) &&
                characterChecked instanceof Magician);
    }

}
