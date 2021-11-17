package classes;

import enums.Factories;
import enums.Notices;
import task1.interfaces.CharacterFactory;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.concurrent.ThreadLocalRandom;


public class Scene {

    final int MAX_CHARACTERS = 10;
    private int curActiveCharacterIndex = -1;

    CharacterFactory.Character[]  characters = new CharacterFactory.Character[MAX_CHARACTERS];

    public void fillScene(){

        ArrayList<Factories> factories = new ArrayList<>(Arrays.asList( Factories.values() )  )  ;
        int curIndex;
        int i = 0;

        while (i < this.MAX_CHARACTERS ){
            curIndex = ThreadLocalRandom.current().nextInt(0 ,factories.size()+1 );

            if(curIndex < factories.size()){
                CharacterFactory factory  = factories.get(curIndex).getFactory();
                characters[i] = factory.createCharacter() ;
                Notifier.notice(Notices.ADD_NEW_PLAYER,characters[i].getName() );
            }

            i++;
        }
        Notifier.notice(Notices.SCENE_WAS_CREATED);
    }
    public boolean areThereCharacters(){
        int cnt =0 ;
        for (int i = 0; i < MAX_CHARACTERS; i++){
            if(characters[i] instanceof CharacterFactory.Character){
                cnt++;
            }
        }
        return cnt>1;
    }

    public CharacterFactory.Character getLastCharacter(){
        int lastCharacterIndex =0 ;
        for (int i = 0; i < MAX_CHARACTERS; i++){
            if(characters[i] instanceof CharacterFactory.Character){
                lastCharacterIndex = i;
            }
        }
        return characters[lastCharacterIndex];
    }

    public CharacterFactory.Character[]  getAllCharacters(){
        return characters;
    }

    public CharacterFactory.Character getActivePerson(){
        this.calculateNextPersonIndex();
        return characters[curActiveCharacterIndex];
    }

    private  void calculateNextPersonIndex(){
       for (int i = curActiveCharacterIndex+1; i <= MAX_CHARACTERS; i++ ){
            if(i == MAX_CHARACTERS){
                curActiveCharacterIndex = -1;
                calculateNextPersonIndex();
            }else if(characters[i] != null ){
                curActiveCharacterIndex = i;
                break;
            }
       }
    }


    public void updateScene(){
        CharacterFactory.Character[]  updateCharacters = new CharacterFactory.Character[MAX_CHARACTERS];

        for (int i = 0 ; i< MAX_CHARACTERS; i++){
            if(characters[i] == null) continue;

            if(  characters[i].getHealth() > 0 ){
                updateCharacters[i] = characters[i];
            }else{
                Notifier.notice(Notices.PLAYER_LOSE,  characters[i].getName() );
            }
        }
        characters = updateCharacters;
    }

}
