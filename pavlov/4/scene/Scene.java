package scene;

import scene.characters.Character;
import scene.characters.generators.ICharacterGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Scene {
    private Character[] characters;
    private ICharacterGenerator characterGenerator;

    private final static int WINNERS_COUNT = 1;
    private final static int MAX_POSITIONS = 10;

    public Scene(ICharacterGenerator generator){
        this.characterGenerator = generator;
        init();
    }

    public Character[] getCharacters() {
        return characters;
    }

    public void setCharacters(Character[] characters) {
        this.characters = characters;
    }

    public ICharacterGenerator getCharacterGenerator() {
        return characterGenerator;
    }

    public void setCharacterGenerator(ICharacterGenerator characterGenerator) {
        this.characterGenerator = characterGenerator;
    }

    public void play(){
        init();
        System.out.println("Новая игра!");
        System.out.println("Сражаются:");
        for(Character character : getAliveCharacters()){
            System.out.println(character.getFullName() + ", HP: " + character.getCurrentHealth());
        }

        while(true){
            for (Character character : characters) {
                if (character == null) {
                    continue;
                }
                character.nextMove(this);

                deleteDeadCharacters();

                Character[] aliveCharacters = getAliveCharacters();
                if(aliveCharacters.length<=WINNERS_COUNT){
                    showResultOfEndGame(aliveCharacters);
                    return;
                }
            }
        }
    }

    public boolean hasCharacter(int position){
        if(characters[position] == null){
            return false;
        }
        return characters[position].getCurrentHealth() > 0;
    }

    public int getPosition(Character character){
        for(int i=0; i<characters.length; i++){
            if(characters[i] == null){
                continue;
            }
            if(characters[i].equals(character)){
                return i;
            }
        }
        return -1;
    }

    public Character getCharacter(int position){
        return characters[position];
    }

    public int maxCharacters(){
        return this.characters.length;
    }

    public Character[] getAliveCharacters(){
        return Arrays.stream(characters)
                .filter(Objects::nonNull)
                .filter(Character::isAlive)
                .toArray(Character[]::new);
    }

    public Character[] getEnemies(Character character){
        Character[] aliveCharacters = getAliveCharacters();
        return Arrays.stream(aliveCharacters)
                .filter(alive -> !character.equals(alive))
                .toArray(Character[]::new);
    }

    private void init(){
        this.characters = new Character[MAX_POSITIONS];
        Random random = new Random();
        int[] positions = random.ints(random.nextInt(MAX_POSITIONS - 2) + 2, 0, MAX_POSITIONS)
                .toArray();
        for(int i : positions){
            characters[i] = characterGenerator.make();
        }
    }

    private void showResultOfEndGame(Character[] winners){
        System.out.println("Игра окончена!");
        if(winners.length == 0) {
            System.out.println("Победителей нет. Все умерли.");
        }
        for(Character winner: winners){
            System.out.println("Победил: " + winner.getFullName());
        }
    }

    private void deleteCharacter(int position){
        characters[position] = null;
    }

    private void deleteDeadCharacters(){
        for(int i=0; i<characters.length; i++){
            Character character = characters[i];
            if(character == null){
                continue;
            }
            if(!character.isAlive()){
                deleteCharacter(i);
            }
        }
    }
}
