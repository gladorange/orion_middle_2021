package filemanager.commands;

import filemanager.FileManager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChangeDirectory extends FileManagerCommand {


    public ChangeDirectory() {
        super("chdir", "Смена текущей директории.");
    }

    @Override
    public void exec(FileManager fileManager) throws FileManagerCommandException {
        String newDir = fileManager.askString("Введите новую дирректорию:");
        Path newPath = Paths.get(newDir).toAbsolutePath();
        if(!Files.exists(newPath)){
            throw new FileManagerCommandException(newDir+" не существует!");
        }
        fileManager.setCurrentDirectory(newPath);
    }
}
