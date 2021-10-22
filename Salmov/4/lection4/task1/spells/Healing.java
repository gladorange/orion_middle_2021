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

    private int healingPoints;

    public Healing(){
        setName("Исцеление");
        Random random = new Random();
        healingPoints = random.nextInt(MAX_HEALING_POINTS-MIN_HEALING_POINTS)+MIN_HEALING_POINTS;
    }

    @Override
    public void cast(Character[] characters, Character spellCaster) {
        int hp = Math.min( DEFAULT_HEALTH_POINTS-spellCaster.getHealthPoints(), healingPoints);
        spellCaster.incHealthPoints(hp);
        System.out.printf("Маг %s исцелен на %s. Теперь у него %s здоровья.\n",spellCaster.getName(),
                hp ,spellCaster.getHealthPoints());
    }
}
