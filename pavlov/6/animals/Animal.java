package animals;

import corteges.Pair;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Animal {
    public static void feedAnimals(List<Pair<Animal,String>> animalsFavoriteDishes){

        int indexLuckyAnimal = new Random().nextInt(animalsFavoriteDishes.size());

        for(int i=0; i<animalsFavoriteDishes.size(); i++){
            Pair<Animal, String> pair = animalsFavoriteDishes.get(i);
            if(i == indexLuckyAnimal){
                System.out.printf("Счастливое животное %S получает двойную порцию %s\n", pair.getFirst().getName(), pair.getSecond());
            }else{
                System.out.printf("Животное %s с радостью съедает %s\n", pair.getFirst().getName(), pair.getSecond());
            }
        }
    }

    private final String name;
    private final String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
