package ru.task5;

public abstract class Character {
    final Scene scene;
    final public int position;
    int health;

    public Character(Scene scene, int position, int health) {
        this.scene = scene;
        this.position = position;
        this.health = health;
    }
    boolean isDead() {
        return health <= 0;
    }
    abstract void act ();
    void say () { System.out.printf("<%s> позиция:[%d] здоровье:%s[%d%%]\n",
            toString(), position, scene.getHealthInBars(health), health); }
}
