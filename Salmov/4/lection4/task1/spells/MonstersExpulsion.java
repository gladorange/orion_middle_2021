package lection4.task1.spells;
import lection4.task1.characters.Character;
import lection4.task1.characters.Monster;

import java.util.Random;

/**
 Изгнание монстров - наносит урон всем монстрам.
 */
public class MonstersExpulsion extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    private int damagePoints;

    public MonstersExpulsion(){
        setName("Изгнание монстров");
        Random random = new Random();
        damagePoints = random.nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS;
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null && !(spellCaster.equals(characters[i])) &&
                        characters[i] instanceof Monster){
                s.append(characters[i].getName());
                s.append(" (Урон:");
                s.append(characters[i].spellCastedHandler(damagePoints));
                s.append(") ");
            }
        }
        System.out.printf("%s ударяет по %s\n", getName() , s);
    }
}
