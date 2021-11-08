package enums;

public enum PetrolType {
    DT("ДТ"),
    AI92("АИ-92"),
    AI95("АИ-95"),
    AI98("АИ-98");

    private String name;

    PetrolType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
