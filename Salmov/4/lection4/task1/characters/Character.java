package lection4.task1.characters;

import static lection4.task1.Helper.DEFAULT_HEALTH_POINTS;

/**
У абстрактного персонажа есть характеристики:
        - Текущее здоровье: целое число
        - Имя: строка
Если текущее здоровье у персонажа стало отрицательным - он
        удаляется со сцены и на экран выводится текст "<имя персонажа> убит"
*/

public abstract class Character {
    private int healthPoints;
    private final String name;

    public Character(String name) {
        this.name = name;
        healthPoints = DEFAULT_HEALTH_POINTS;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void decHealthPoints(int n){
        healthPoints -= n;
    }

    public void incHealthPoints(int n){
        healthPoints += n;
    }

    public String getName() {
        return name;
    }

    public void killedHandler(){
        System.out.println(name + " убит");
    }

    public void winningHandler() {
        System.out.println("Победил " + getCharacterType() + " " +getName());
    }

    public Boolean isAlive() {
        if(getHealthPoints()<0){
            System.out.println(getName()+" убит");
            return false;
        } else {
            return true;
        }
    }

    public abstract void doAction(Character[] characters);
    public abstract int attackedHandler(int damage);
    public abstract int spellCastedHandler(int damage);
    public abstract String getCharacterType();
    public abstract String getDescription();
}
