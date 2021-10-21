package ru.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wizard extends ru.task5.Character {
    final private List<Spell> bookOfSpells;    //  книга (список) заклинаний для данного мага. конечно же private Ж:)

    public Wizard(Scene scene, int position, int health, int bookOfSpellsCapacity) {
        super(scene, position, health);
        //  создаём книгу заклинаний:
        bookOfSpells = new ArrayList<>(bookOfSpellsCapacity);
        final SpellFact spellsFactory = new SpellFact();
        //  заполняем книгу заклинаний для данного мага:
        try {
            for (int i = 0; i < bookOfSpellsCapacity; i++) {
                bookOfSpells.add(i, spellsFactory.getRandomSpell(scene, this));
            }
        } catch (IllegalStateException e) {
            System.out.println("Произошло исключение IllegalStateException в методе getRandomSpell() класса SpellFactory!");
        }
    }

    @Override
    void act() {
        //  немного поколдуем (берём случайное заклинание из книги):
        //  Можно использовать Collections.shuffle чтобы перемешать коллекцию и взять первые n элементов - это эмулирует "случайность"
        Collections.shuffle(bookOfSpells);
        Spell spellApplied = bookOfSpells.get(0);
        //  some printout:
        System.out.printf("МАГ <%s>, позиция: %d, ЗАКЛИНАЮ: %s\n", toString(), position, spellApplied.name);
        //  применяем выбранное заклинание:
        spellApplied.cast();
    }
}
