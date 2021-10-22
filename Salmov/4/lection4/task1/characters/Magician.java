package lection4.task1.characters;

import lection4.task1.spells.Spell;
import lection4.task1.spells.SpellsFabric;

import java.util.Random;

/**
Маги. Могут колдовать заклинания. Заклинания могут делать что угодно со сценой и персонажами на ней.
У каждого мага есть список заклинаний (книга заклинаний), которые он может использовать, но не больше 3.
 Если маг произносит любое заклинание то экран обязательно должен выводится общий текст для всех заклинаний:
 "Маг <имя> читает заклинание <название заклинания>"
*/

public class Magician extends Character{
    Spell[] spells;

    public Magician(String name) {
        super(name);
        spells = SpellsFabric.makeSpells();
    }

    @Override
    public void doAction(Character[] characters) {
        if(getHealthPoints()<0)
            return;
        Random random = new Random();
        Spell spell = spells[random.nextInt(spells.length)];
        System.out.printf("Маг %s читает заклинание %s\n", getName(), spell.getName());
        spell.cast(characters, this);
    }

    @Override
    public int attackedHandler(int damage) {
        decHealthPoints(damage);
        return damage;
    }

    @Override
    public int spellCastedHandler(int damage) {
        decHealthPoints(damage);
        return damage;
    }

    @Override
    public String getCharacterType() {
        return "маг";
    }

    @Override
    public String getDescription() {
        StringBuilder spellsDescription = new StringBuilder();
        for(Spell s: spells){
            spellsDescription.append("(");
            spellsDescription.append(s.getName());
            spellsDescription.append(")");
        }
        return getCharacterType()+"("+getName()+", здоровье: "+ getHealthPoints() +
                ", заклинания(" + spellsDescription + ")";
    }

}
