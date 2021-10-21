package scene.characters.wizzard;

import scene.Scene;
import scene.characters.Character;
import scene.characters.wizzard.magick.Spell;

import java.util.Arrays;
import java.util.Random;

public class Wizzard extends Character {
    public static int MAX_SPELLS_SIZE = 3;

    private Spell[] spells;

    public Wizzard(int currentHealth, String name, Spell[] spells) {
        super(currentHealth, name, "Маг");
        this.spells = spells;
        validateSpells(spells);
    }

    @Override
    public void nextMove(Scene scene) {
        Spell spell = selectSpell();
        spell.cast(this, scene);
    }

    public Spell[] getSpells() {
        return spells;
    }

    public void setSpells(Spell[] spells) {
        this.spells = spells;
        validateSpells(spells);
    }

    private Spell selectSpell(){
        Random random = new Random();
        return spells[random.nextInt(spells.length)];
    }

    private void validateSpells(Spell[] spells){
        if(spells.length > MAX_SPELLS_SIZE){
            throw new IllegalArgumentException("Заклинаний не может быть больше "+MAX_SPELLS_SIZE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wizzard wizzard = (Wizzard) o;
        return Arrays.equals(spells, wizzard.spells);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(spells);
        return result;
    }
}
