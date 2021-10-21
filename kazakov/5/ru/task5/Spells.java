package ru.task5;

import java.util.List;

//  Заклинание: "Исцеление" - добавляет здоровья магу, произнесшему заклинание
class Heal extends Spell {
    Heal(Scene scene, Wizard owner) {
        super(" ♥♥♥HEAL♥♥♥ ", scene, owner);
    }

    @Override
    void cast() {
        //  Исцеление - добавляет здоровья магу, произнесшему заклинание:
        owner.health += Main.MONSTER_AVERAGE_DAMAGE;
        //  органичиваем максимальное кол-во здоровья магу, чтобы он не был "перекачанным":
        if (owner.health > Main.CHARACTERS_MAX_HEALTH)
            owner.health = Main.CHARACTERS_MAX_HEALTH;
    }
}

// Молния - наносит урон любому персонажу:
class Lightning extends Spell {
    Lightning(Scene scene, Wizard owner) {
        super("↕↕↕LIGHTNING↕↕↕", scene, owner);
    }

    @Override
    void cast() {
        int enemyIndex = scene.getRandomEnemy(owner.position);
        Character enemy = scene.getCharacter (enemyIndex);
        assert (enemy != null);
        //  наносим ущерб другому персонажу:
        enemy.health -= Main.MONSTER_AVERAGE_DAMAGE;
    }
}

// Цепная молния - наносит урон, всем персонажам на сцене, кроме мага, который произносит заклинание:
class ChainLightning extends Spell {
    ChainLightning(Scene scene, Wizard owner) {
        super("↰↰↰CHAINLIGHTNING↱↱↱", scene, owner);
    }

    @Override
    void cast() {
        List<Character> chars = scene.getCharactersList();
        Character enemy;
        //  наносим урон всем персонажам на сцене, кроме самого себя:
        for (int i = 0; i < chars.size(); i++) {
            enemy = scene.getCharacter(i);
            //  наносим урон всем кроме самого себя, размер урона обратно пропорц.числу игроков на сцене:
            if (enemy != null && !enemy.equals(owner))
                enemy.health -= Main.MONSTER_AVERAGE_DAMAGE / scene.getNumOfAlive();
        }
    }
}

// Стена огня - наносит урон всем персонажам на четных позициях:
class WallOfFire extends Spell {
    WallOfFire(Scene scene, Wizard owner) {
        super("║║║WALLOFFIRE║║║", scene, owner);
    }

    @Override
    void cast() {
        List<Character> chars = scene.getEvenCharactersList();
        Character enemy;
        //  наносим урон, кроме самого себя:
        for (int i = 0; i < chars.size(); i++) {
            enemy = scene.getCharacter(i);
            //  наносим урон всем кроме самого себя, размер урона обратно пропорц.числу игроков на сцене:
            if (enemy != null && !enemy.equals(owner))
                enemy.health -= Main.MONSTER_AVERAGE_DAMAGE / scene.getNumOfAlive();
        }
    }
}

//  Огненное касание - наносит урон персонажу, стоящему на соседней с магом позиции:
//  Если на соседних позициях персонажей нет - никому урон не наносится
class FireTouch extends Spell {
    FireTouch(Scene scene, Wizard owner) {
        super("╢╢╢FIRETOUCH╟╟╟", scene, owner);
    }

    @Override
    void cast() {
        //  наносим урон соседям:
        for (Character enemy : scene.getNeighboursList(owner.position)) {
            enemy.health -= Main.MONSTER_AVERAGE_DAMAGE / 2;    //  стандартный урон для соседей делится на 2
        }
    }
}

//  Изгнание монстров - наносит урон всем монстрам:
class ExpulsionMonters extends Spell {
    ExpulsionMonters(Scene scene, Wizard owner) {
        super("𝔐𝔐𝔐EXPULSEMONSTERS𝔐𝔐𝔐", scene, owner);
    }

    @Override
    void cast() {
        List<Character> monsters = scene.getMonstersList();
        //  урон обратно пропорционален кол-ву монстров:
        monsters.forEach(x -> x.health -= Main.MONSTER_AVERAGE_DAMAGE / monsters.size());
    }
}

//  Мигрень - наносит урон всем магам:
class HeadAche extends Spell {
    HeadAche(Scene scene, Wizard owner) {
        super("⨀⨀⨀HEADACHE⨀⨀⨀", scene, owner);
    }

    @Override
    void cast() {
        List<Character> wizards = scene.getWizardsList();
        //  урон обратно пропорционален кол-ву монстров:
        wizards.forEach(x -> { if (x.position != owner.position) x.health -= Main.MONSTER_AVERAGE_DAMAGE / (wizards.size() - 1); });
    }
}
