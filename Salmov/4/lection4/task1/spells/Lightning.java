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

    private int damagePoints;

    public Lightning(){
        setName("Молния");
        Random random = new Random();
        damagePoints = random.nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS;
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        int identifiedTarget = Helper.identifyTarget(characters, spellCaster);
        int madeDamage = characters[identifiedTarget].spellCastedHandler(damagePoints);
        System.out.printf("%s ударяет по %s. Он получает %s урона.\n", getName(),
                characters[identifiedTarget].getName(), madeDamage);
    }
}
