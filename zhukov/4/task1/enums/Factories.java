package task1.enums;

import task1.classes.MonsterFactory;
import task1.classes.WizardFactory;
import task1.interfaces.CharacterFactory;

public enum Factories {

    WIZARD(new WizardFactory()),
    MONSTER(new MonsterFactory());

    final CharacterFactory factory ;

    Factories(CharacterFactory factory){
        this.factory = factory;
    }
    public CharacterFactory getFactory(){
        return this.factory;
    }



}
