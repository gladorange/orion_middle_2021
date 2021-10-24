package scene.characters.wizzard.magick;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.Wizzard;

import java.util.Objects;

public abstract class Spell {

    private String name;
    private int power;

    public Spell(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public void cast(Wizzard wizzard, Scene scene){
        Character[] targets = selectTargets(wizzard, scene);

        System.out.println(wizzard.getFullName() + " читает заклинание " + getName());

        String message = getCastMessage(wizzard, targets);
        if(!message.isEmpty()){
            System.out.println(getCastMessage(wizzard, targets));
        }

        for(Character target : targets){
            cast(target);
        }
    }

    protected abstract String getCastMessage(Wizzard wizzard, Character[] targets);

    protected abstract void cast(Character target);

    protected abstract Character[] selectTargets(Wizzard wizzard, Scene scene);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Objects.equals(name, spell.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
