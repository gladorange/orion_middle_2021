package task4.entity;

public interface BaseActions<T extends Entity> {
    int attack(T object);
    void restoreHealth(int amount);
    void loseHealth(int amount);
    void restoreMana(int amount);
    void loseMane(int amount);
    void info();
}
