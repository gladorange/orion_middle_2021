package task4.entity.characters;

import task4.entity.AttackType;
import task4.entity.Entity;

public class Monster extends Entity {

    public Monster(String name) {
        this.setMaxHealthPoints(100);
        this.setHealthPoints(100);
        this.setName(name);
        this.setAttackType(AttackType.PHYSICAL);
        this.setAttackDamage(5);
    }
}
