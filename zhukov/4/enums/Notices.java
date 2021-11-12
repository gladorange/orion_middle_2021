package enums;

public enum Notices {
    SCENE_WAS_CREATED("Сцена подготовлена \n"),
    ADD_NEW_PLAYER("Добавлен новый персонаж %s \n"),
    PLAYER_LOSE("Игрок %s вышел из игры \n"),
    PLAYER_WIN("Игрок %s выиграл \n"),
    PLAYER_ATTACK("Игрок %s атакует \n"),
    PLAYER_ALREADY_SPELL("Игрок %s уже использовал все свои заклинания \n"),
    PLAYER_MONSTER_ATTACK("Монстр %s атакует %s \n"),
    GAME_WILL_NEVER_END("Игра никогда не закончится у всех волшебников закончились заклинания  \n"),
    WINNER_IS("Победитель  %s - %s  \n"),
    PLAYER_SAY_SPELL("Волшебник %s произносит заклинание %s  \n"),
    PLAYER_READ_SPELL("%s  \n");

    private String comment;

    Notices( String comment ){
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
