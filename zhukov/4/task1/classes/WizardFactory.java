package task1.classes;

import task1.interfaces.CharacterFactory;

public class WizardFactory implements CharacterFactory {

    public static class WizardAttack{

    }

    public class Wizard extends  CharacterFactory.Character {

        Wizard(String name, int health){
            super( name,health);
        }

        public void attack(Character[] characters,Character character) {

        }
    }

    public CharacterFactory.Character createCharacter(String name, int health){
        return  new Wizard(name,  health);
    }
}
