package ru.task8.Lection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/*
    Создайте класс Lection с полями : название, дата проведения.
    Описывает лекцию по какой-то дисциплине в определенную дату.
    В качестве даты можете использовать LocalDate, используя конструктор LocalDate.of
 */
class Lection {
    private final Discipline discipline;
    private final LocalDate date;

    public Lection(Discipline disc, LocalDate eventDate) {
        this.discipline = disc;
        this.date = eventDate;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public LocalDate getEventDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lection lection = (Lection) o;
        return discipline == lection.discipline &&
                Objects.equals(date, lection.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discipline, date);
    }
}

//  Создайте класс Student с полями имя (строка) и список посещенных курсов в формате Set<Lection>.
class Student {
    private final String name;
    private final Set<Lection> lections = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public String getName() {
        return name;
    }

    /**
     * feedWithLections ()
     * набиваем посещаемость Студента за сегодня
     * случайный набор Дисциплин, который посетил данный студент за сегодня
     */
    void feedWithLections(LocalDate date) {
        //  проходимся случайно по всем дисциплинам и заполняем посещаемость на сегодня:
        for (Discipline ignored : Discipline.values()) {
            //  добавляем новую (случайную) прослушанную Дисциплину в Set посещённых для нашего студента:
            lections.add(new Lection(Discipline.values()[ThreadLocalRandom.current().nextInt(0, Discipline.values().length)], date));
        }
    }

    /*
     * DumpLections - helper method
     * вываливаем в консоль список лекций , который посетил данный студент:
    void DumpLections() {
        lections.forEach(l -> System.out.printf("'%s' посетил '%s' лекцию: %s\n", name, l.getEventDate(), l.getDiscipline()));
    }
     */
}
