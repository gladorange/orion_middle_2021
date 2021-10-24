package scene.characters.generators;

import scene.characters.Character;

public interface ICharacterGenerator extends IGenerator<Character> {
    Character make();
}
