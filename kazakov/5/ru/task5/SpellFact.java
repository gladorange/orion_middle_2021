package ru.task5;

import java.util.concurrent.ThreadLocalRandom;

public class SpellFact {
    //  делаем простейшее генерирование нового заклинания для мага:
    Spell getRandomSpell(Scene scene, Wizard wizard) throws IllegalStateException {
        return switch (ThreadLocalRandom.current().nextInt(0, 7)) {
            case 0 -> new Heal(scene, wizard);
            case 1 -> new Lightning(scene, wizard);
            case 2 -> new ChainLightning(scene, wizard);
            case 3 -> new WallOfFire(scene, wizard);
            case 4 -> new FireTouch(scene, wizard);
            case 5 -> new ExpulsionMonters(scene, wizard);
            case 6 -> new HeadAche(scene, wizard);
            default -> throw new IllegalStateException("Unexpected value in getRandomSpell(...) func");
        };
    }
}
