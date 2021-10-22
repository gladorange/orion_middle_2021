package lection4.task1;

import lection4.task1.characters.Character;

public class Helper {
    public static final int DEFAULT_HEALTH_POINTS = 100;

    public static int identifyTarget(Character[] characters, Character character){
        //плюсуем 1, чтобы избежать ситуации, что будет выбран персонаж на 0 позиции
        //при этом позиция вовсе и не занята
        int minHealth = DEFAULT_HEALTH_POINTS+1;
        int identifiedTarget = (character.equals(characters[0]))?1:0;
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] != null &&
                    !(character.equals(characters[i])) &&
                    characters[i].getHealthPoints() >= 0 &&
                    minHealth > characters[i].getHealthPoints()){
                identifiedTarget = i;
                minHealth = characters[i].getHealthPoints();
            }
        }
        return identifiedTarget;
    }
}
