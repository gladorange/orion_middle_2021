package ru.task5;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * зафигачим наш итератор для реализации случайной очередности ходов наших персонажей на сцене:
 *
 * @author Kazakov Marat
 * @since 1.2
 */
public class ShuffleIterator implements Iterator<Character> {
    final List<Character> originList;
    //  список хода - для каждого из персонажа, хранит булевы значения: true - персонаж ещё не ходил; false - ходил
    final List<Boolean> iteratorList;

    public ShuffleIterator(List<Character> origin) {
        originList = origin;
        iteratorList = new ArrayList<>();
        for (int i = 0; i < origin.size(); i++) {
            if (origin.get(i) != null)
                iteratorList.add(i, Boolean.TRUE);
            else
                iteratorList.add(i, Boolean.FALSE);
        }
    }

    @Override
    public boolean hasNext() {
        return iteratorList.stream().filter(Objects::nonNull).anyMatch(x -> x);
    }

    @Override
    public Character next() {
        int index;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (true) {
            index = ThreadLocalRandom.current().nextInt(0, iteratorList.size());
            //  ищем случайный персонаж, который ещё не ходил:
            if (!iteratorList.get(index))
                continue;
            iteratorList.set(index, false);
            return originList.get(index);
        }
    }
}

