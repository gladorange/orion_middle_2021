package filemanager.commands;

import filemanager.FileManager;

public class Exit extends FileManagerCommand {


    public Exit() {
        super("exit", "Выход из программы");
    }

    @Override
    public void exec(FileManager fileManager) {
        System.out.println("До свидания!");
        fileManager.exit();
    }
}
