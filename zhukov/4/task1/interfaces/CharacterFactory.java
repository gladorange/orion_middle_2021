package task1.interfaces;

public interface CharacterFactory {

    public interface Attack {

        public void attack(CharacterFactory.Character[] characters , CharacterFactory.Character character);

    }

      abstract class Character implements Attack {

        String name ;
        int health ;
        Spell[] spellsBook ;

        public Character(String name, int health) {
            this.name = name;
            this.health = health;
        }

        public abstract void attack(Character[] characters ,Character character);

        public void reduceHealth(int points){
            this.health -= points;
        }

        public void setHealth(int points){
            this.health = points;
        }
    }

    public CharacterFactory.Character  createCharacter(String name, int health);
}
