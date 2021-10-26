package task1.enums;

import task1.classes.Spell;
import task1.classes.SpellStrategy;
import task1.classes.SpellStrategy.*;

public enum SpellLibrary {

    HEALING( new SpellHealing(),"Исцеление","Исцеляй что то там" ),
    LIGHTNING ( new SpellLightning(),"Молния","Молния что то там" ),
    CHAIN_LIGHTNING(  new SpellChainLightning(),"Цепная молния","Здесь звучит текст заклинания Цепная молния %s" ),
    FIRE_WALL( new SpellFireWall(),"Стена огня","Здесь звучит текст заклинания Стена огня"),
    FIRE_TOUCH( new SpellFireTouch(),"Огненное касание" ,"Здесь звучит текст заклинания Огненное касание");

    private  SpellStrategy strategy ;
    private String title;
    private String description;

    SpellLibrary(SpellStrategy strategy, String title, String description){
        this.strategy = strategy;
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return this.title;
    }

    public String getDescription() {
        return description;
    }

    public void execute(Spell spell) {
        this.strategy.execute( spell );
    }

}
