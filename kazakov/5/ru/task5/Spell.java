package ru.task5;

public abstract class Spell {
    final String name;    //  название заклинания
    final Scene scene;    //  заклинание действует на сцене
    final Wizard owner;   //  заклинание имеет своего владельца (того кто произносит)

    Spell(String name, Scene scene, Wizard owner) {
        this.scene = scene;
        this.name = name;
        this.owner = owner;
    }
    abstract void cast();
}
