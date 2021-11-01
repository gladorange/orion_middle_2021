package task4.entity;

import java.util.Objects;

public abstract class Entity implements BaseActions {
    private int healthPoints;
    private int manaPoints;
    private int attackDamage;
    private String name;
    private int maxHealthPoints;
    private int maxManaPoints;
    private AttackType attackType;
    private boolean isAlive;


    @Override
    public int attack(Entity entity) {
        System.out.println("******************************************************************");
        System.out.println(this.getName() + " attacks " + entity.getName());
        entity.loseHealth(this.attackDamage);
        int hpAfterAttack = entity.getHealthPoints();
        System.out.println(entity.getName() + " was attacked by " + this.getName() + ". hp left " + hpAfterAttack);
        System.out.println("******************************************************************");
        if(entity.getHealthPoints() < 1) {
            entity.setAlive(false);
        }
        return hpAfterAttack;
    }

    @Override
    public void restoreHealth(int amount) {
        setHealthPoints(this.healthPoints + amount);
        System.out.println(this.getName() + " has healthPoints: " +this.getHealthPoints());
    }

    @Override
    public void loseHealth(int amount) {
        setHealthPoints(this.healthPoints - amount);
        System.out.println(this.getName() + " healthPoints left: " +this.getHealthPoints());
    }

    @Override
    public void restoreMana(int amount) {
        setManaPoints(this.manaPoints + amount);
        System.out.println(this.getName() + " has manaPoints: " +this.getManaPoints());
    }

    @Override
    public void loseMane(int amount) {
        setManaPoints(this.manaPoints - amount);
        System.out.println(this.getName() + " manaPoints left: " +this.getManaPoints());
    }

    @Override
    public void info() {
        System.out.println("Name: " + this.name + "\nCurrentHP: " + this.healthPoints +
                "\nCurrentMP: " + this.manaPoints);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            this.healthPoints = 0;
        } else if (healthPoints > this.maxHealthPoints) {
            this.healthPoints = this.maxHealthPoints;
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        if (manaPoints < 0) {
            this.manaPoints = 0;
        } else if (manaPoints > this.manaPoints) {
            this.manaPoints = this.maxManaPoints;
        } else {
            this.manaPoints = manaPoints;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        this.maxManaPoints = maxManaPoints;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nCurrentHP: " + this.healthPoints +
                "\nCurrentMP: " + this.manaPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return healthPoints == entity.healthPoints && manaPoints == entity.manaPoints && attackDamage == entity.attackDamage && maxHealthPoints == entity.maxHealthPoints && maxManaPoints == entity.maxManaPoints && Objects.equals(name, entity.name) && attackType == entity.attackType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, manaPoints, attackDamage, name, maxHealthPoints, maxManaPoints, attackType);
    }
}
