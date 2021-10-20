package scene.characters;

import scene.Scene;

import java.util.List;
import java.util.Objects;

public abstract class Character {
    private int currentHealth;
    private String name;
    private String gameClassName;

    public Character(int currentHealth, String name, String gameClassName){
        this.currentHealth = currentHealth;
        this.name = name;
        this.gameClassName = gameClassName;
    }

    public abstract void nextMove(Scene scene);

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameClassName() {
        return gameClassName;
    }

    public void setGameClassName(String gameClassName) {
        this.gameClassName = gameClassName;
    }

    public String getFullName(){
        return gameClassName + " " +name;
    }

    public final void takeDamage(int damage){
        int takenDamage = calculateDamage(damage);
        currentHealth = currentHealth - takenDamage;
        System.out.println("У " + getFullName() + " осталось " + currentHealth + " единиц здоровья.");
        if(!isAlive()){
            System.out.println(getFullName() + " умер.");
        }
    }

    public final void restoreHealth(int healingPoints){
        int takenHealing = calculateRestoreHealth(healingPoints);
        System.out.println(getFullName() + " получает " + takenHealing + "единиц здоровья.");
    }

    public int calculateDamage(int damage){
        return damage;
    }

    public int calculateRestoreHealth(int healingPoints){
        return healingPoints;
    }

    public boolean isAlive(){
        return currentHealth >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return currentHealth == character.currentHealth &&
                Objects.equals(name, character.name) &&
                Objects.equals(gameClassName, character.gameClassName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentHealth, name, gameClassName);
    }
}
