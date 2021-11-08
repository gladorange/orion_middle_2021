package filemanager;

import filemanager.commands.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {
    private Path currentDirectory;
    private boolean running;

    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, FileManagerCommand> commands= new HashMap<>();

    public FileManager(){
        this(Paths.get(""));
    }

    public FileManager(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
        fillCommands();
    }

    public void run(){
        running = true;
        while(running){
            try {
                nextCommand();
            } catch (FileManagerException | FileManagerCommand.FileManagerCommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void exit(){
        running=false;
    }

    public Collection<FileManagerCommand> getCommands(){
        return commands.values();
    }

    private void nextCommand() throws FileManagerException, FileManagerCommand.FileManagerCommandException {
        FileManagerCommand command = readCommand();
        command.exec(this);
    }

    private FileManagerCommand readCommand() throws FileManagerException {
        String cliInput = askString("Введите команду (man - вызов справки):");
        return findCommand(cliInput);
    }

    public String askString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    private FileManagerCommand findCommand(String commandName) throws FileManagerException {
        FileManagerCommand command = commands.get(commandName);
        if(command==null){
            throw new FileManagerException("Комманда "+commandName+" не обнаружена.");
        }
        return command;
    }

    private void fillCommands(){
        commands.clear();

        appendCommand(new ViewCurrentDirectory());
        appendCommand(new Manual());
        appendCommand(new Exit());
        appendCommand(new ChangeDirectory());
        appendCommand(new DeleteFile());
        appendCommand(new CreateFile());
        appendCommand(new AppendTextToFIle());
        appendCommand(new ViewFiles());
    }

    private void appendCommand(FileManagerCommand fileManagerCommand){
        commands.put(fileManagerCommand.getCommandName(), fileManagerCommand);
    }

    public Path getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Path currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public String toString() {
        return "FileManager{" +
                "currentDirectory=" + currentDirectory +
                '}';
    }

    public static class FileManagerException extends Exception {
        public FileManagerException(String message){
            super(message);
        }
    }
}
