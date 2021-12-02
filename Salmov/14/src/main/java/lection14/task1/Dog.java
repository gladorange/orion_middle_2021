package lection14.task1;

public class Dog extends Animal{
    public Dog(String name, Integer volume) {
        super(name, volume);
    }

    @Override
    public String getAnimalType() {
        return "собака";
    }

    @Override
    public String getSoundType() {
        return "гавканья";
    }
}
