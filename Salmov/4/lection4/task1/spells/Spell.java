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
    private final int effectPoints;

    protected Spell(int effectPoints) {
        this.effectPoints = effectPoints;
    }

    public String getName() {
        return name;
    }

    public int getEffectPoints() {
        return effectPoints;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract void cast(Character[] characters, Character spellCaster);

    protected abstract boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked);

    public void castMultiTarget(Character[] characters, Character spellCaster) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            if(checkCharacter(characters[i], spellCaster, i)){
                s.append(characters[i].getName());
                s.append(" (Урон:");
                s.append(characters[i].spellCastedHandler(effectPoints));
                s.append(") ");
            }
        }
        System.out.printf("%s ударяет по %s\n", getName(), s);
    }
}
