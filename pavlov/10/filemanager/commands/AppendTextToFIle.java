package filemanager.commands;

import filemanager.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppendTextToFIle extends FileManagerCommand {

    public AppendTextToFIle() {
        super("fappendtext", "Дописать текст в файл");
    }

    @Override
    public void exec(FileManager fileManager) throws FileManagerCommandException {
        Path path = Paths.get(fileManager.getCurrentDirectory().normalize().toString(), fileManager.askString("Введите имя файла:"));
        if(!Files.exists(path)){
            throw new FileManagerCommandException("Файл "+path.toAbsolutePath().toString()+" не существует!");
        }
        String text = fileManager.askString("Введите текст для записи в файл:");
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileManagerCommandException("Ошибка при записи в файл "+path.toAbsolutePath().toString()+": "+e.getMessage());
        }
    }
}
