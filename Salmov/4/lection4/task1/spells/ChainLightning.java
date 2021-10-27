package lection4.task1.spells;
import lection4.task1.characters.Character;

import java.util.Random;

/**
 Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание.
 */
public class ChainLightning extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    public ChainLightning(){
        super((new Random()).nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS);
        setName("Цепная молния");
        Random random = new Random();
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        castMultiTarget(characters, spellCaster);
    }

    @Override
    protected boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked) {
        return (characterChecked != null && !(spellCaster.equals(characterChecked)));
    }

}
