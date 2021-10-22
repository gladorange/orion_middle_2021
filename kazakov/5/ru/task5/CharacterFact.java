package ru.task5;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterFact {

    Character getRandomCharacter(Scene scene, int position) throws IllegalStateException {
        return switch (ThreadLocalRandom.current().nextInt(0, Main.NUMBER_OF_CHARACTERS_WITH_EMPTY_CHARACTER)) {
            case 0 -> new Monster(scene, position, Main.CHARACTERS_MAX_HEALTH, Main.MONSTER_AVERAGE_DAMAGE + ThreadLocalRandom.current().nextInt(-Main.MONSTER_MAX_DEVIATION, Main.MONSTER_MAX_DEVIATION + 1));
            case 1 -> new Wizard(scene, position, Main.CHARACTERS_MAX_HEALTH, Main.WIZARD_BOOK_OF_SPELLS_MAX_CAPACITY);
            case 2 -> null;
            default -> throw new IllegalStateException("Unexpected value in getRandomCharacter(...) func ");
        };
    }
}
