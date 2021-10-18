package lection4.task1.spells;
import lection4.task1.characters.Character;

import java.util.Random;

/**
 Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции.
 Если на соседних позициях персонажей нет - никому урон не наносится.
 */
public class FieryTouch extends Spell{

    static final int MIN_DAMAGE_POINTS = 10;
    static final int MAX_DAMAGE_POINTS = 30;

    private int damagePoints;

    public FieryTouch(){
        setName("Огненное касание");
        Random random = new Random();
        damagePoints = random.nextInt(MAX_DAMAGE_POINTS-MIN_DAMAGE_POINTS)+MIN_DAMAGE_POINTS;
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        int myIndex = 0;
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null && spellCaster.equals(characters[i])){
                myIndex = i;
                break;
            }
        }
        if(myIndex>0 && characters[myIndex-1] !=null){
            System.out.printf("%s ударяет по %s. Урон: %s.\n", getName() , characters[myIndex-1].getName(),
                    characters[myIndex-1].spellCastedHandler(damagePoints));
        }
        if((myIndex<characters.length-1) && characters[myIndex+1] !=null){
            System.out.printf("%s ударяет по %s. Урон: %s.\n", getName() , characters[myIndex+1].getName(),
                    characters[myIndex+1].spellCastedHandler(damagePoints));
        }
    }
}
