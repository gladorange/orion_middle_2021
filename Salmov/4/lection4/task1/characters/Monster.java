package lection4.task1.characters;

import lection4.task1.Helper;

import java.util.Random;

/**
Монстры. Могут атаковать любого персонажа, напрямую нанося урон здоровью.
        Количество урона для каждого конкретного монстра одинаковое, но
        разные экземпляры монстров могут наносить разное количество урона.
        Если монстр атакует любого персонажа, - на экран должен выводится
        текст "Монстр <имя> атакует <имя, цели> на <количество> единиц урона урона "
*/

public class Monster extends Character{
    static final int MIN_DIRECT_DAMAGE = 10;
    static final int MAX_DIRECT_DAMAGE = 30;

    private final int directDamage;

    public Monster(String name) {
        super(name);
        Random random = new Random();
        directDamage = random.nextInt(MAX_DIRECT_DAMAGE-MIN_DIRECT_DAMAGE)+MIN_DIRECT_DAMAGE;
    }

    @Override
    public void doAction(Character[] characters) {
        if(getHealthPoints()<0)
            return;
        int identifiedTarget = Helper.identifyTarget(characters, this);
        int madeDamage = characters[identifiedTarget].attackedHandler(directDamage);
        System.out.printf("Монстр %s атакует %s на %s единиц урона\n", getName(),
                characters[identifiedTarget].getName(), madeDamage);
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
        return "мостр";
    }

    @Override
    public String getDescription() {
        return getCharacterType()+"("+getName()+", здоровье: "+ getHealthPoints() +
                ", наносит вред: " + directDamage;
    }

}
