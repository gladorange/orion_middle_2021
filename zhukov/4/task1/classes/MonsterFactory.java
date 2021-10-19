package task1.classes;

import task1.interfaces.CharacterFactory;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterFactory implements CharacterFactory {

    public class Monster extends CharacterFactory.Character implements Attack {

        private int personalHarm ;

        Monster(String name, int health){
            super(name, health);
            this.personalHarm = ThreadLocalRandom.current().nextInt(0,100);
        }

        public void attack(CharacterFactory.Character[] characters ,CharacterFactory.Character character){
            character.reduceHealth(this.personalHarm);
        }
    }

    public CharacterFactory.Character createCharacter(String name, int health){
        return  new Monster(name,  health);
    }
}
