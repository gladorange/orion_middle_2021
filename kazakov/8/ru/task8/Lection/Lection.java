package ru.task8.Lection;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

enum Discipline {
    MATH("матанализ"), PHILOSOPHY("философия"),
    ENGLISH("английкий язык"), HISTORY("история"),
    PHYSICAL("физкультура");

    final private String name;

    Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

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

    public Discipline getName() {
        return discipline;
    }

    public LocalDate getEventDate() {
        return date;
    }
}

//  Создайте класс Student с полями имя (строка) и список посещенных курсов в формате Set<Lection>.
class Student {
    private final String name;
    private final Set<Lection> lections;

    public Student(String name, Set<Lection> lections) {
        this.name = name;
        this.lections = lections;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public String getName() {
        return name;
    }
}

