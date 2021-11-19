package enums;

import classes.MonsterFactory;
import classes.WizardFactory;
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
