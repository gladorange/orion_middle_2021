package task1;

import task1.classes.Notifier;
import task1.classes.Scene;

import task1.classes.WizardFactory;
import task1.enums.Notices;
import task1.interfaces.CharacterFactory;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Scene scene = new Scene();
        scene.fillScene();

        CharacterFactory.Character curCharacter;

        while( scene.areThereCharacters()){
            curCharacter = scene.getActivePerson();
            curCharacter.attack(scene.getAllCharacters());

            scene.updateScene();

            if(Arrays.stream(scene.getAllCharacters()).allMatch(e->(e instanceof WizardFactory.Wizard && ((WizardFactory.Wizard) e).usedSpell == ((WizardFactory.Wizard) e).MAX_SPELLS_COUNT )) ){
                Notifier.notice(Notices.GAME_WILL_NEVER_END );
                break;
            }
        }
        CharacterFactory.Character winner = scene.getLastCharacter();
        Notifier.notice(Notices.WINNER_IS, winner.getPersonType() , winner.getName() );
    }
}
