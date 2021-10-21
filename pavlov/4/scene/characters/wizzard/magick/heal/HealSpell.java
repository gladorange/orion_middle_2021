package scene.characters.wizzard.magick.heal;

import scene.characters.Character;
import scene.characters.wizzard.Wizzard;
import scene.characters.wizzard.magick.Spell;

public abstract class HealSpell extends Spell {
    public HealSpell(String name, int power) {
        super(name, power);
    }

    @Override
    protected void cast(Character target) {
        target.restoreHealth(getPower());
    }

    @Override
    protected String getCastMessage(Wizzard wizzard, Character[] targets){
        if(targets.length == 0){
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<targets.length; i++){
            Character target = targets[i];
            stringBuilder.append(target.getName());
            if(targets.length>1 && i != targets.length-1){
                stringBuilder.append(",");
            }
        }
        return getName() + " исцеляет " + stringBuilder.toString() + (targets.length==1 ? " он " : " каждый ")  +" востанавливает " + getPower() + " единиц здоровья.";
    }
}
