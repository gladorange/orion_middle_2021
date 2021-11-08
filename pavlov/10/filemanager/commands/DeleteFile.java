package filemanager.commands;

import filemanager.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFile extends FileManagerCommand {
    public DeleteFile() {
        super("fdelete", "Удаление файла");
    }

    @Override
    public void exec(FileManager fileManager) throws FileManagerCommandException {
        try {
            Path path = Paths.get(fileManager.askString("Введите имя файла:")).toAbsolutePath();
            boolean fileExist = Files.deleteIfExists(path);
            if(!fileExist){
                throw new FileManagerCommandException(path.toAbsolutePath().toString()+" не существует!");
            }
        } catch (IOException e) {
            throw new FileManagerCommandException("Не удалось удалить файл по причине:"+e.getMessage());
        }
    }
}
