package ru.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Scene {
    //  персонажи на сцене
    final private List<Character> characters;
    //  список для порядка ходов (вообще нужно бы сделать iterator но это видимо в следующих версиях игры :)
    private int step = 0;   //  текущий шаг в игре
    int killed = 0; //  подсчитываем тела убитых
    final public int initNumOfCharacters; //  первоначальное число игроков в игре

    //  конструируем сцену, декорации, случайно расставляем персонажей:
    public Scene(int charactersNum) {
        characters = new ArrayList<>(charactersNum);
        final CharacterFact charFactory = new CharacterFact();
        //  генерируем персонажей: с равной вероятностью монстра, мага или оставляем пустое место на сцене:
        for (int i = 0; i < charactersNum; i++) {
            try {
                characters.add(charFactory.getRandomCharacter(this, i));
            } catch (IllegalStateException e) {
                System.out.println("Произошло исключение IllegalStateException в методе getRandomSpell() класса SpellFactory!");
            }
        }
        //  запоминаем первонач.число игроков в игре:
        initNumOfCharacters = getNumOfAlive();
    }

    List<Character> getCharactersList() {
        return characters;
    }

    int getStep() {
        return step;
    }

    /**
     * getCharacter() - Ф-я возвращает персонажа на данной позиции
     *
     * @param index - позиция персонажа (индекс)
     * @return Character in given position, MAY BE NULL IN initial EMPTY POSITION or IF KILLED & wiped out!
     */
    Character getCharacter(int index) {
        return characters.get(index);
    }

    /**
     * getNumOfAlive() - Ф-я возвращает кол-во персонажей в игре (живых)
     *
     * @return Кол-во персонажей, оставшихся в живых игре - после текущего шага
     */
    int getNumOfAlive() {
        return (int) characters.stream().filter(Objects::nonNull).count();
    }

    //  helper func, get THE WINNER OF THE GAME!
    Character getWinner() {
        for (Character item : characters) {
            if (item != null)
                return item;
        }
        return null;
    }

    /**
     * RemoveCorpses () - remove dead bodies from the scene and wipe out the blood
     * <p>
     * Если текущее здоровье у персонажа стало отрицательным - он удаляется со сцены и на экран выводится текст "<имя персонажа> убит"
     */
    void removeCorpses() {
        for (int i = 0; i < characters.size(); i++) {
            Character item = getCharacter(i);
            if (item != null && item.isDead()) {
                System.out.printf("<%s> убит на позиции:[%d].\n", item.toString(), item.position);
                characters.set(i, null);    //  МК нам нужно не просто удалить элемент, но и принудительно установить его в null
                killed++;
            }
        }
    }

    /**
     * BypassScene()  - baypass the entire scene and
     * ask all characters to invoke their method say()
     * then print to console
     */
    void passOverScene() {
        System.out.printf("[ОБХОД на шаге: %d, живых: %d, убито: %d]\n", step, getNumOfAlive(), killed);
        for (Character item : characters) {
            if (item != null)
                item.say();
            else
                System.out.println("null");
        }
    }

    /**
     * Scene.nextStep() - Ф-я делает шаг в игре.
     * <ul>
     * <li> обходим всю сцену.</li>
     * <li> каждый персонаж по очереди применяет свою магическую силу.</li>
     * </ul>
     *
     * @since 1.0
     */
    public void nextStep() {
        //  apply actions:
        /*
        for (Character item : characters) {
            if (item != null) {
                item.act();
                //  2. remove corpses:
                removeCorpses();
            }
        }
         */
        ShuffleIterator it = new ShuffleIterator(characters);
        while (it.hasNext()) {
            Character item = it.next();
            if (item != null) {
                item.act();
                //  2. remove corpses:
                removeCorpses();
            }
        }
        //  increment game step:
        step++;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    //  ф-ии для персонажей (для выполнения их могии):

    /**
     * getRandomEnemy ()  - получаем врага (случайного объекта) для атаки для данного персонажа
     *
     * @param index - позиция персонажа, который будет атаковать
     * @return случайно сгенерированная позиция врага, на которого будет совершена атака (1.not null 2.not equals index)
     */
    int getRandomEnemy(int index) {
        int enemyIndex;
        do {
            enemyIndex = ThreadLocalRandom.current().nextInt(0, characters.size());
            if (enemyIndex == index)
                continue;
            if (getCharacter(enemyIndex) != null)
                break;
        } while (true);  //  персонаж не может атаковать сам себя
        assert (enemyIndex != -1 && enemyIndex < Main.SCENE_POSITIONS_NUM);  //  небольшой assert
        return enemyIndex;
    }

    /**
     * getMonstersList ()  - получаем список ВСЕХ монстров (без исключений) на сцене
     *
     * @return -  List <Character> , not null, contains no null elements
     */
    List<Character> getMonstersList() {
        List<Character> monsterList = new ArrayList<>();
        for (Character item : characters) {
            if (item != null) {
                if (item instanceof Monster)
                    monsterList.add(item);
            }
        }
        return monsterList;
    }

    /**
     * getWizardsList ()  - получаем список ВСЕХ магов (без исключений) на сцене
     *
     * @return -  List <Character> , not null, contains no null elements
     */
    List<Character> getWizardsList() {
        List<Character> wizardList = new ArrayList<>();
        for (Character item : characters) {
            if (item != null) {
                if (item instanceof Wizard)
                    wizardList.add(item);
            }
        }
        return wizardList;
    }

    /**
     * getEvenCharactersList ()  - получаем список всех персонажей стоящих на ЧЁТНЫХ позициях на сцене
     *
     * @return -  List of <Character> , not null, contains no null elements
     */
    List<Character> getEvenCharactersList() {
        List<Character> evenList = new ArrayList<>();
        for (int i = 0; i < characters.size(); i += 2) {    //  считаем что 0 - чётное
            Character item = characters.get(i);
            if (item != null) {
                evenList.add(item);
            }
        }
        return evenList;
    }

    /**
     * getNeighboursList ()  - получаем список соседних элементов, относительно данного на сцене
     *
     * @param index - позиция персонажа, для которого получаем соседние элементы
     * @return -  List of <Character> , not null, contains no null elements
     */
    List<Character> getNeighboursList(int index) {
        List<Character> neighbourList = new ArrayList<>();
        //  получаем только один соседний элемент:
        int left = index - 1;
        if (left >= 0) {
            Character item = characters.get(left);
            if (item != null) {
                neighbourList.add(item);
            }
        }
        //  получаем только один соседний элемент:
        int right = index + 1;
        if (right < characters.size()) {
            Character item = characters.get(right);
            if (item != null) {
                neighbourList.add(item);
            }
        }
        assert (neighbourList.size() <= 2); //  соседей не может быть больше 2х
        return neighbourList;
    }

    /**
     * getHealthByBars ()  - создаём строку здоровья, в виже столбиков, в псевдографике :)
     * ф-я НЕ УЧИТЫВАЕТ "перекачанности" персонажа, считается что MAX_HEALTH == 100
     *
     * @param healthInPercents - здоровье персонажа в процентах
     * @return - строка здоровья, готовая для вывода с помощью System.out.println(...) например
     */
    String getHealthInBars(int healthInPercents) {
        final int MAX_HEALTH_IN_PERCENTS = 100;
        final int BARS_TOTAL_NUM = 20;  //  здоровье рисуем в 20 столбиков, но можно и изменить например 10
        final int PERCENTS_IN_ONE_CHAR = MAX_HEALTH_IN_PERCENTS / BARS_TOTAL_NUM;  //  сколько процентов в 1 столбике псевдографики
        final String HEALTHY_CHAR = "█";
        final String DEAD_OUT_CHAR = "▒";
        //final int deadInPercents = MAX_HEALTH_IN_PERCENTS - healthInPercents;  //  на сколько процентов персонаж мёртв

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < healthInPercents; i += PERCENTS_IN_ONE_CHAR)
            sb.append(HEALTHY_CHAR);
        for (int i = healthInPercents; i < MAX_HEALTH_IN_PERCENTS; i += PERCENTS_IN_ONE_CHAR)
            sb.append(DEAD_OUT_CHAR);
        return sb.toString();
    }

}

