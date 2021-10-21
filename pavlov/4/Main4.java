import scene.Scene;
import scene.characters.Character;
import scene.characters.generators.*;
import scene.characters.wizzard.magick.Spell;
import scene.characters.wizzard.magick.damage.*;
import scene.characters.wizzard.magick.heal.Healing;

import java.util.Random;

public class Main4 {
    public static void main(String[] args) {
        Scene scene = new Scene(getCharacterGenerator());
        scene.play();
    }

    public static final int MIN_HEALTH = 10;
    public static final int MAX_HEALTH = 100;

    public static final int MIN_DAMAGE = 1;
    public static final int MAX_DAMAGE = 40;

    public static final Spell[] spells = new Spell[]{
            new ChainLightning(10),
            new Exorcism(30),
            new FieryTouch(10),
            new Firewall(30),
            new Lightning(10),
            new Migraine(5),
            new Healing(20)
    };

    public static final String[] monsterNames = new String[]{
            "Крыса",
            "Скелет",
            "Зомби",
            "Призрак",
            "Лич",
            "Бандит",
            "Некромант",
            "Дракон",
            "Темный рыцарь"
    };

    public static final String[] wizzardNames = new String[]{
            "Мерлин",
            "Гарри Поттер",
            "Гендальф",
            "Ринсвинд",
            "Магистр Йода",
            "Нагибатор666"
    };

    private static ICharacterGenerator getCharacterGenerator(){
        return new ICharacterGenerator() {

            Random random = new Random();

            ICharacterGenerator[] generators = new ICharacterGenerator[]{
                    getMonsterRandomGenerator(random),
                    getWizzardRandomGenerator(random)
            };

            AbstractCharacterGenerator.ElementFromArrayGenerator<ICharacterGenerator> typeCharacterGenerator =
                    new AbstractCharacterGenerator.ElementFromArrayGenerator<>(random, generators);

            @Override
            public Character make() {
                return typeCharacterGenerator.make().make();
            }
        };
    }

    private static MonsterGenerator getMonsterRandomGenerator(Random random){
        return new MonsterGenerator(
            new AbstractCharacterGenerator.RangeIntGenerator(random, MIN_HEALTH, MAX_HEALTH),
            new AbstractCharacterGenerator.ElementFromArrayGenerator<>(random, monsterNames),
            new AbstractCharacterGenerator.RangeIntGenerator(random, MIN_DAMAGE, MAX_DAMAGE)
        );
    }

    private static WiizzardGenerator getWizzardRandomGenerator(Random random){
        return new WiizzardGenerator(
                new AbstractCharacterGenerator.RangeIntGenerator(random, MIN_HEALTH, MAX_HEALTH),
                new AbstractCharacterGenerator.ElementFromArrayGenerator<>(random, wizzardNames),
                new AbstractCharacterGenerator.ElementFromArrayGenerator<>(random, spells)
        );
    }
}
