package task1.classes;

import task1.enums.Notices;
import task1.interfaces.CharacterFactory;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterFactory implements CharacterFactory {

    public class Monster extends CharacterFactory.Character   {

        private int personalHarm ;
        private String[] names = {
                "Василиск",
                "Гиппогриф",
                "Садовый Гном",
                "Грифон",
                "Единорог",
                "Феникс",
                "Фея",
                "Химера",
                "Дракон",
                "Валлийский зелёный"
        };

        Monster(){
            super();
            personType = "Монстр";
            personalHarm = ThreadLocalRandom.current().nextInt(30,90);
            int randNameIndex = ThreadLocalRandom.current().nextInt(0 , names.length );
            this.setName( names[randNameIndex]  );
        }



        public void attack(Character[] characters) {

            Integer randomCharacter = ThreadLocalRandom.current().nextInt(0, characters.length);

            if( characters[randomCharacter] != null && !this.equals(characters[randomCharacter]) ){
                Notifier.notice(Notices.PLAYER_MONSTER_ATTACK,this.getName(), characters[randomCharacter].getName() );
                characters[randomCharacter].reduceHealth( personalHarm );
            }else{
                attack(characters);
            }

        }
    }

    @Override
    public CharacterFactory.Character createCharacter(){
        return  new Monster();
    }

}
