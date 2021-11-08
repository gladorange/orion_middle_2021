package filemanager.commands;

import filemanager.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFile  extends FileManagerCommand {

    public CreateFile() {
        super("fcreate", "Создать файл");
    }

    @Override
    public void exec(FileManager fileManager) throws FileManagerCommandException {
        Path path = Paths.get(fileManager.getCurrentDirectory().normalize().toString(), fileManager.askString("Введите имя файла:")).toAbsolutePath();
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new FileManagerCommandException("Не удалось создать файл "+path.toAbsolutePath().toString()+" по причине: "+e.getMessage());
        }
    }
}
