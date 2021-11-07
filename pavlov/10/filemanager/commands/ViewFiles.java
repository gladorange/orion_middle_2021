package filemanager.commands;

import filemanager.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ViewFiles extends FileManagerCommand {

    public ViewFiles() {
        super("flist", "Список файлов");
    }

    @Override
    public void exec(FileManager fileManager) throws FileManagerCommandException {
        String dir = fileManager.askString("Введите имя каталога для просмотра файлов (по умолчанию будет выбрана текущая папка):");
        Path path = fileManager.getCurrentDirectory();
        if(!dir.isEmpty()){
            path = Paths.get(dir);
        }
        if(!Files.isDirectory(path)){
            throw new FileManagerCommandException(path.toAbsolutePath().toString()+" не является каталогом.");
        }
        File fileDir = new File(path.toAbsolutePath().toString());
        for(File file: Objects.requireNonNull(fileDir.listFiles())){
            System.out.println(file.getName());
        }
    }
}
