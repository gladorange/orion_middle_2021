package filemanager.commands;

import filemanager.FileManager;

import java.util.Objects;

public abstract class FileManagerCommand {
    private final String commandName;
    private final String info;

    FileManagerCommand(String commandName, String info){
        this.commandName = commandName;
        this.info = info;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getInfo() {
        return info;
    }

    public abstract void exec(FileManager fileManager) throws FileManagerCommandException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileManagerCommand command = (FileManagerCommand) o;
        return Objects.equals(commandName, command.commandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandName);
    }

    public static class FileManagerCommandException extends Exception{
        FileManagerCommandException(String message){
            super(message);
        }
    }
}
