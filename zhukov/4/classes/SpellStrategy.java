package classes;

public abstract class SpellStrategy {

    public abstract void execute(Spell spell);

    public static class SpellHealing extends SpellStrategy {
        public void execute(Spell spell){
            int personalHarm = 11;
            spell.getAuthor().increaseHealth(personalHarm);
        }
    }

    public static class SpellLightning extends SpellStrategy {
        public void execute(Spell spell){
            int personalHarm = 11;
            int curPersonIndex = -1;
            for(int i = 0; i< spell.getCharacters().length; i++){
                if(spell.getCharacters()[i] != null &&
                        !spell.getCharacters()[i].equals(spell.getAuthor()) &&
                        curPersonIndex > -1
                ){
                    spell.getCharacters()[i].reduceHealth(personalHarm);
                    break;
                }
                if( spell.getCharacters()[i] != null && spell.getCharacters()[i].equals(spell.getAuthor())){
                    curPersonIndex = i;
                }
            }
        }
    }

    public static class SpellChainLightning extends SpellLightning {
        public void execute(Spell spell) {
            int personalHarm = 40;
            for(int i = 0; i< spell.getCharacters().length; i++){
                if(spell.getCharacters()[i] != null && !spell.getCharacters()[i].equals(spell.getAuthor())){
                    spell.getCharacters()[i].reduceHealth(personalHarm);
                }
            }
        }
    }

        public static class SpellFireWall extends SpellStrategy {
            public void execute(Spell spell){
                Integer personalHarm = 35;

                for(int i = 0; i< spell.getCharacters().length; i++){
                    if(spell.getCharacters()[i] != null &&
                            !spell.getCharacters()[i].equals(spell.getAuthor()) &&
                            i%2 == 0
                    ){
                        spell.getCharacters()[i].reduceHealth(personalHarm);

                    }

                }
            }
        }
        public static class SpellFireTouch extends SpellStrategy {

            public void execute(Spell spell){

                Integer firstCharacterIndex = -1 ;
                final int SPELL_HARM = 40;
                boolean attacked = false;

                for(int i = 0 ; i< spell.getCharacters().length; i++){
                    if(spell.getCharacters()[i] != null &&
                           // curPlayerIndex > -1 &&
                            !spell.getCharacters()[i].equals(spell.getAuthor()) &&
                            !attacked
                    ){
                        spell.getCharacters()[i].reduceHealth(SPELL_HARM);
                        attacked = true;
                    }
                    if(firstCharacterIndex < 0 && spell.getCharacters()[i] != null ){
                        firstCharacterIndex = i;
                    }

                }
                if(!attacked){
                    spell.getCharacters()[firstCharacterIndex].reduceHealth(SPELL_HARM);

                }
            }
        }
}

