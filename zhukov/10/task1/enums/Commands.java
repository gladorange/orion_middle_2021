package task1.enums;

import task1.classes.commands.*;
import task1.interfaces.Command;


public enum Commands {

    CHANGE_DIR("cd", new ChangeDir() ),
    CREATE_FILE("mk", new MkFile() ),
    CREATE_DIR("mkdir", new MkDir() ),
    DELETE_FILE("del", new DelFile() ),
    CHANGE_FILE("write", new WriteToFile() ),
    LOOK_DIR("look", new LookCurDir() );

    String title ;
    Command cmd ;

    Commands(String title, Command cmd){
        this.title = title;
        this.cmd = cmd;
    }

    public String getTitle() {
        return title;
    }

    public Command getCmd() {
        return cmd;
    }
}
