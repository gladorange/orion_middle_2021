package scene.characters;

import scene.Scene;

import java.util.Objects;
import java.util.Random;

public class Monster extends Character {

    private int attackPower;

    public Monster(int currentHealth, String name, int attackPower) {
        super(currentHealth, name, "Монстр");
        this.attackPower = attackPower;
    }

    @Override
    public void nextMove(Scene scene) {
        Character[] targetsForAttack = scene.getEnemies(this);
        Character target = selectTarget(targetsForAttack);
        if(target == null){
            return;
        }
        System.out.println(getFullName() + " атакует " + target.getFullName() + " на " + attackPower + " единиц урона.");
        target.takeDamage(attackPower);
    }

    private Character selectTarget(Character[] targetsForAttack){
        if(targetsForAttack.length == 0){
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(targetsForAttack.length);
        return targetsForAttack[randomIndex];
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return attackPower == monster.attackPower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attackPower);
    }
}
