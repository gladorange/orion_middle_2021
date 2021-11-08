package filemanager.commands;

import filemanager.FileManager;

public class ViewCurrentDirectory extends FileManagerCommand {

    public ViewCurrentDirectory() {
        super("curdir", "Просмотр текущей директории");
    }

    @Override
    public void exec(FileManager fileManager) {
        System.out.println("current dir:> "+fileManager.getCurrentDirectory().toAbsolutePath().toString());
    }
}
