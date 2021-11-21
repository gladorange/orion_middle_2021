package task1.classes;

import task1.interfaces.Command;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class FileManager {

    final String exitPoint = "exit";
    String command ;
    String param;
    Map<String, Command> commands ;

    public boolean handleCommand(){

        System.out.println("Please enter some command");

        Scanner scanner = new Scanner(System.in);
        String enteredText = scanner.nextLine();

        if(enteredText.equals(exitPoint) ){
            return false;
        }

        if(enteredText.contains("\s")){
            String enteredArgs[] = enteredText.split("\s");
            command = enteredArgs[0];
            param = enteredArgs[1];
        }else{
            command = enteredText;
        }

        return true;
    }

    public void setAllowsCommands(Map<String, Command> commands){
        this.commands  = commands;
    }

    public void execute() throws IOException {
        Command cmd = commands.get(command);
        if(cmd != null )  {
            cmd.execute(param);
        }else{
            System.out.print("Command wasn't found");
        }
    }
}
