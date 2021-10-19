package lection4.task1.characters;

import java.util.Random;

public class CharactersFabric {
    enum CharacterTypes {MONSTER,MAGICIAN}

    static final String[] POSSIBLE_NAMES = {"Дэвид","Дерек","Итан","Фредди","Мерлин",
            "Эндрю","Арнольд","Остин","Брайан","Чарльз","Грант","Джеффри","Хью","Джаспер",
            "Кевин","Курт","Лестер","Мартин","Норман","Трэвис"};

    public static Character makeCharacter(){
        Random random = new Random();
        String name = POSSIBLE_NAMES[random.nextInt(POSSIBLE_NAMES.length)];
        //Добавляем единицу, чтобы некоторые поля на сцене оказались без персонажей
        int i = random.nextInt(CharacterTypes.values().length+1);
        if(i<CharacterTypes.values().length) {
            switch (CharacterTypes.values()[i]) {
                case MONSTER:
                    return new Monster(name);
                case MAGICIAN:
                    return new Magician(name);
            }
        }
        return null;
    }
}
