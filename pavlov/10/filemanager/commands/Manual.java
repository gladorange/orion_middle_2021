package filemanager.commands;

import filemanager.FileManager;

import java.util.Collection;

public class Manual extends FileManagerCommand {

    public Manual() {
        super("man", "Справка");
    }

    @Override
    public void exec(FileManager fileManager) {
        Collection<FileManagerCommand> commands = fileManager.getCommands();
        System.out.println("Доступные команды:");
        for(FileManagerCommand command: commands){
            System.out.println("\t"+command.getCommandName()+" - "+command.getInfo());
        }
    }
}
