package lection14.task1;

public class Cat extends Animal{
    public Cat(String name, Integer volume) {
        super(name, volume);
    }

    @Override
    public String getAnimalType() {
        return "кот";
    }

    @Override
    public String getSoundType() {
        return "мурчания";
    }
}
