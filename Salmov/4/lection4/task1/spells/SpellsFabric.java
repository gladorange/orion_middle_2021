package lection4.task1.spells;

import java.util.Random;

public class SpellsFabric {
    static final int MIN_SPELLS_CNT = 1;
    //максимальное число заклинаний не должно быть больше числа существующих заклинаний
    static final int MAX_SPELLS_CNT = 3;

    enum SpellTypes {HEALING,LIGHTNING,CHAIN_LIGHTNING,WALL_OF_FIRE,FIERY_TOUCH,MONSTERS_EXPULSION,MIGRAINE}

    public static Spell[] makeSpells(){
        Random random = new Random();
        Spell[] spells = new Spell[random.nextInt(MAX_SPELLS_CNT)+MIN_SPELLS_CNT];
        SpellTypes[] selectedTypes = new SpellTypes[spells.length];
        for (int i = 0; i < spells.length; i++) {
            boolean notExist;
            SpellTypes checkType;
            do{
                notExist = false;
                checkType = SpellTypes.values()[random.nextInt(SpellTypes.values().length)];
                for(SpellTypes t: selectedTypes){
                    if(t == checkType){
                        notExist = true;
                        break;
                    }
                }
            } while(notExist);
            selectedTypes[i] = checkType;
            spells[i] = makeSpell(checkType);
        }
        return spells;
    }

    private static Spell makeSpell(SpellTypes type){
        switch (type) {
            case HEALING:
                return new Healing();
            case LIGHTNING:
                return new Lightning();
            case CHAIN_LIGHTNING:
                return new ChainLightning();
            case WALL_OF_FIRE:
                return new WallOfFire();
            case FIERY_TOUCH:
                return new FieryTouch();
            case MONSTERS_EXPULSION:
                return new MonstersExpulsion();
            case MIGRAINE:
                return new Migraine();
        }
        return null;
    }

}
