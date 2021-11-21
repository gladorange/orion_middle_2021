package task1;

import org.jetbrains.annotations.NotNull;
import task1.classes.ApplicationRegister;
import task1.classes.FileManager;
import task1.enums.Commands;
import task1.interfaces.Command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //Расширяемость проекта достигается путем использования шаблона Команда
    public static void main(String[] args) throws IOException {

        Map<String, Command> commands = prepareCommandMap();
        ApplicationRegister appReg = ApplicationRegister.getInstance();
        appReg.set("curDir",System.getProperty("user.dir"));

        FileManager fm = new FileManager();
        fm.setAllowsCommands(commands);

        while( fm.handleCommand()){
            fm.execute();
        }
    }

    @NotNull
    private static Map<String, Command> prepareCommandMap() {

        Map<String, Command> commands  = new HashMap<>();
        for (Commands value : Commands.values()) {
            commands.put(value.getTitle() , value.getCmd());
        }
        return commands;
    }
}
