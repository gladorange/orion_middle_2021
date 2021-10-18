package lection4.task1.spells;

import lection4.task1.characters.Character;

/**
класс Spell с методом cast - произнесение заклинания и полем "название заклинания".
 + дополнительно должен быть выведен текст, зависящий от заклинания.
 Например
 "Маг Merlin читает заклинание Цепная Молния."
 "Цепная молния ударяет по Трус, Бывалый, Балбес. Каждый получает 5 урона."

*/

public abstract class Spell {
    private String name;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract void cast(Character[] characters, Character spellCaster);

}
