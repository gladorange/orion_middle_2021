package task1.enums;

public enum Wizards {

    HARRY("Гарри Поттер",true),
    GERMIONA("Гермиона Грейнджер",true),
    NEVIL("Невилл Долгопупс",false),
    DARKO("Драко Малфой",true),
    SEDRIC("Седрик Диггори",false),
    MINERVA("Минерва Макгонагалл",true),
    ALBUS("Альбус Дамблдор",true),
    SEVERUS("Минерва Макгонагалл",true),
    HAGRID("Рубеус Хагрид",true),
    BLACK("Сириус Блэк",true);

    String name ;
    Boolean warrior;

    Wizards(String name, Boolean warrior){
        this.name = name;
        this.warrior = warrior;
    }

    public String getName() {
        return name;
    }

    public Boolean isWarrior() {
        return warrior;
    }
}
