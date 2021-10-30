package lection7.task1.items;

public enum FruitColor {
    RED("красные"),GREEN("зелёные"),YELLOW("жёлтые"),
    RED_YELLOW("красные с жёлтым"), RED_WHITE("красные с белым"),
    YELLOW_WHITE("жёлтые с белым"), GREEN_WHITE("зелёные с белым");
    private final String name;
    FruitColor(String name){
        this.name = name;
    }
    public String getName(){ return name;}
}

