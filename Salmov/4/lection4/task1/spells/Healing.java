package lection4.task1.spells;
import lection4.task1.characters.Character;

import java.util.Random;

import static lection4.task1.Helper.DEFAULT_HEALTH_POINTS;

/**
 Исцеление - добавляет очков здоровья магу, произнесшему заклинания.
 + выводится текст, зависящий от заклинания.
 Например: "Маг Merlin исцелен на 12. Теперь у него 20 здоровья"
 */
public class Healing extends Spell{

    static final int MIN_HEALING_POINTS = 10;
    static final int MAX_HEALING_POINTS = 30;

    public Healing(){
        super((new Random()).nextInt(MAX_HEALING_POINTS-MIN_HEALING_POINTS)+MIN_HEALING_POINTS);
        setName("Исцеление");
        Random random = new Random();
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        int hp = Math.min( DEFAULT_HEALTH_POINTS-spellCaster.getHealthPoints(), getEffectPoints());
        spellCaster.incHealthPoints(hp);
        System.out.printf("Маг %s исцелен на %s. Теперь у него %s здоровья.\n",spellCaster.getName(),
                hp ,spellCaster.getHealthPoints());
    }

    @Override
    protected boolean checkCharacter(Character characterChecked, Character spellCaster, int indexChecked) {
        return false;
    }

}
