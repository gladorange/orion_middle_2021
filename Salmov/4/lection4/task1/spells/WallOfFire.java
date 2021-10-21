package lection4.task1.spells;

import lection4.task1.characters.Character;

import java.util.Random;

/**
 Стена огня - наносит урон всем персонажам на четных позициях.
 */
public class WallOfFire extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    public WallOfFire(){
        super((new Random()).nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS);
        setName("Стена огня");
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        castMultiTarget(characters, spellCaster);
    }

    @Override
    protected boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked) {
        return (characterChecked != null && !(spellCaster.equals(characterChecked)) &&
                indexChecked%2 ==0);
    }

}
