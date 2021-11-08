package ru.task8.Lection;

public enum Discipline {
    MATH("матанализ"), PHILOSOPHY("философия"),
    ENGLISH("английкий язык"), HISTORY("история"),
    PHYSICAL("физкультура");

    final private String name;

    Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
