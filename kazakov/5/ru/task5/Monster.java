package ru.task5;

public class Monster extends ru.task5.Character {
    final int damage;

    public Monster(Scene scene, int position , int health, int damage) {
        super(scene, position, health);
        this.damage = damage;
    }
    @Override
    void act () {
        //  получаем случайную цель для атаки:
        int randEnemyIndex = scene.getRandomEnemy(position);
        Character randEnemy = scene.getCharacter (randEnemyIndex);
        //  some printout:
        System.out.printf("МОНСТР <%s> позиция:%d АТАКУЮ✠✠✠ <%s> на позиции:%d, наношу урон:%d\n",
                toString(), position, randEnemy.toString(), randEnemyIndex, damage);
        //  наносим ущерб противнику:
        randEnemy.health -= damage;
    }
}
