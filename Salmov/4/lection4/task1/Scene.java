package lection4.task1;

import lection4.task1.characters.Character;
import lection4.task1.characters.CharactersFabric;

/**
На сцену можно добавить до 10 Персонажей (Character)
у каждого персонажа есть позиция (от 0 до 9). На которой он стоит.
На позиции с одинаковым номером может стоять только один персонаж.
В позициях допускаются пропуски, например, на сцене могут быть всего
два персонажа: на позиции 1 и на позиции 7.
*/

public class Scene {
    static final int MAX_CHARACTERS_ON_SCENE = 10;
    Character[] characters;

    public Scene(){
        characters = new Character[MAX_CHARACTERS_ON_SCENE];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = CharactersFabric.makeCharacter();
        }
        showSceneExtended();
    }

    public void showSceneExtended(){
        System.out.println("На сцене:");
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                System.out.printf("[%s:%s)]\n", i, characters[i].getDescription());
            } else {
                System.out.printf("[%s:__]\n",i);
            }
        }
        System.out.println();
    }

    public void showScene(){
        System.out.println("На сцене:");
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                System.out.printf("[%s:%s(%s:%s)] ", i, characters[i].getCharacterType(),
                        characters[i].getName(), characters[i].getHealthPoints());
            } else {
                System.out.printf("[%s:__] ",i);
            }
        }
        System.out.println();
    }

    public void nextStep(){
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                characters[i].doAction(characters);
            }
        }
        removeDeadCharacters();
        showScene();
        System.out.println();
    }

    private void removeDeadCharacters(){
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                if(!characters[i].isAlive())
                    characters[i]=null;
            }
        }
    }

    public int getCharactersOnScene(){
        int cnt = 0;
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                cnt++;
            }
        }
        return cnt;
    }

    public void showWinner(){
        for (int i = 0; i < characters.length; i++) {
            if(characters[i]!=null) {
                characters[i].winningHandler();
            }
        }
    }
}
