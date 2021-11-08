package task4.entity.characters;

import task4.entity.AttackType;
import task4.entity.Entity;

public class Mage extends Entity {

    public Mage(String name) {
        this.setMaxHealthPoints(100);
        this.setMaxManaPoints(100);
        this.setHealthPoints(100);
        this.setManaPoints(100);
        this.setName(name);
        this.setAttackType(AttackType.MAGICAL);
        this.setAttackDamage(10);
    }

    public void healSpell() {
        if(this.getManaPoints() > 20) {
            loseMane(20);
            restoreHealth(10);
        }
    }

    public void getManaSpell() {
        if(this.getManaPoints() > 20) {
            loseMane(20);
            restoreMana(30);
        }
    }

    public void lightingAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using lightning");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void superLightingAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using super lightning");
        loseMane(10);
        entity.loseHealth(10);
    }
    public void hyperLightingAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using hyper lightning");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void megaLightingAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using mega lightning");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void superFireballAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using super fireball");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void fireballAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using fireball");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void hyperFireballAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using hyper fireball");
        loseMane(10);
        entity.loseHealth(10);
    }

    public void megaFireballAttack(Entity entity) {
        System.out.println("Mage attacks " + entity.getName() + " using mega fireball");
        loseMane(10);
        entity.loseHealth(10);
    }


}
