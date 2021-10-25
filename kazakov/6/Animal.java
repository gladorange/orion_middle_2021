
/*
Задание А. Работа с парами:
        Создайте класс Animal с полями имя(String) и тип животного (тоже String)
*/

public class Animal {
    private final String name;
    private final String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}

