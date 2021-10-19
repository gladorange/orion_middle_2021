package task1.classes;

import task1.enums.Factories;
import task1.interfaces.CharacterFactory;
import task1.classes.MonsterFactory;
import task1.classes.WizardFactory;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.concurrent.ThreadLocalRandom;


public class Scene {

    final int MAX_CHARACTERS = 10;
    ArrayList< CharacterFactory.Character > characters;

    public void fillScene(){

        int i = 0;
        ArrayList<Factories> factories = new ArrayList<>(Arrays.asList( Factories.values() )  )  ;

        while (i < this.MAX_CHARACTERS ){

            int inc = ThreadLocalRandom.current().nextInt(0 ,factories.size() );
            System.out.printf("%s\n ",inc);
            if(inc == factories.size()){
                continue;
            }else{

                CharacterFactory factory;
                factory = factories.get(inc).getFactory();
                this.characters.add( factory.createCharacter("character #"+i , 100) );
            }

            i++;
        }
        //System.out.print(factories.toString());
    }

    public void upadateScene(){

    }

}
