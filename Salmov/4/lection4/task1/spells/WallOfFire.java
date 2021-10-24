package lection4.task1.spells;
import lection4.task1.characters.Character;

import java.util.Random;

/**
 Стена огня - наносит урон всем персонажам на четных позициях.
 */
public class WallOfFire extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    private int damagePoints;

    public WallOfFire(){
        setName("Стена огня");
        Random random = new Random();
        damagePoints = random.nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS;
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < characters.length; i+=2) {
            if(characters[i] != null && !(spellCaster.equals(characters[i]))){
                s.append(characters[i].getName());
                s.append(" (Урон:");
                s.append(characters[i].spellCastedHandler(damagePoints));
                s.append(") ");
            }
        }
        System.out.printf("%s ударяет по %s\n", getName(), s);

    }
}
