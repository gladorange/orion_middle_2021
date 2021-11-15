package lection10.task1;

import lection10.task1.commands.*;

import java.util.*;

public class CommandsHandler {
    private static final List<Command> commands = new ArrayList<>(
            Arrays.asList(
                    new Dir(),
                    new Cd(),
                    new Rd(),
                    new Md(),
                    new Del(),
                    new New(),
                    new Add(),
                    new Look()
            )
    );

    public static void handleCommands() {
        while(true) {
            System.out.print(System.getProperty("user.dir")+">");
            Scanner myScan = new Scanner(System.in);
            String cmd = myScan.nextLine() ;
            if(cmd.equals("exit"))
                return;
            if(cmd.equals("help")){
                System.out.println("Посмотри как много команд я знаю:");
                for (Command command: commands) {
                    System.out.println(command.getHelp());
                }
                continue;
            }
            boolean commandDetected = false;
            for (Command command: commands ) {
                if(command.isInString(cmd)){
                    command.execute(cmd);
                    commandDetected = true;
                    break;
                }
            }
            if(!commandDetected)
                System.out.println("Ты хочешь от меня невозможного, такую команду я не знаю!");
        }
    }
}
