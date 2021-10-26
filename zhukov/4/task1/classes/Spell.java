package task1.classes;

import task1.enums.SpellLibrary;
import task1.interfaces.CharacterFactory;
import task1.interfaces.CharacterFactory.Character;

public class Spell{
    private Character   author ;
    private Character[] characters ;

    public Spell(Character author ,Character[] characters) {
        this.characters = characters;
        this.author = author;
    }

    void cast(SpellLibrary spellEnum ){
        spellEnum.execute( this );
    }

    public Character getAuthor() {
        return author;
    }

    public Character[] getCharacters() {
        return characters;
    }
}
