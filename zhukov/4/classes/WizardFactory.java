package classes;

import enums.Notices;
import enums.SpellLibrary;
import enums.Wizards;
import task1.interfaces.CharacterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class WizardFactory implements CharacterFactory {


    public class Wizard extends  Character {

        final public int MAX_SPELLS_COUNT = 3;


        private ArrayList<SpellLibrary> spells = new ArrayList<>(Arrays.asList( SpellLibrary.values() )  )  ;
        private ArrayList<Wizards> availebleCharacters = new ArrayList<>(Arrays.asList( Wizards.values() )  )  ;
        public int usedSpell = 0;

        Wizard(){
            super( );
            personType = "Волшебник";
            int randNameIndex = ThreadLocalRandom.current().nextInt(0 , availebleCharacters.size());
            this.setName( availebleCharacters.get( randNameIndex ).getName() );

        }

        public void attack(CharacterFactory.Character[] characters) {

            if(usedSpell < MAX_SPELLS_COUNT){
                Spell spell = new Spell( this, characters );
                SpellLibrary usingSpell = this.choseRandomSpell();

                Notifier.notice(Notices.PLAYER_SAY_SPELL,this.getName(), usingSpell.getTitle() );
                Notifier.notice(Notices.PLAYER_READ_SPELL, usingSpell.getDescription() );

                spell.cast( usingSpell );
                usedSpell++;
            }else{
                Notifier.notice(Notices.PLAYER_ALREADY_SPELL,this.getName() );
            }
        }

        private SpellLibrary choseRandomSpell(){
            int randomSpell = ThreadLocalRandom.current().nextInt(0,SpellLibrary.values().length) ;
            SpellLibrary spell = spells.get(randomSpell) ;
            return spell;
        }
    }

    @Override
    public Character createCharacter(){
        return  new Wizard();
    }
}
