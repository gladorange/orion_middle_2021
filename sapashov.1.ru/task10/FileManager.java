package task10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public void list(String folderPath) {
        File file = new File(folderPath);
        if (file.exists() && file.isDirectory()) {
            String[] folders = file.list();
            if (folders.length == 0) {
                System.out.println("Folder is empty");
            } else {
                for (String str : folders) {
                    System.out.println(str);
                }
            }
        } else {
            System.out.println("Wrong path entered!");
        }
    }

    public void createDir(String folderPath) {
        File folder = new File(folderPath);
        boolean isCreated = folder.mkdir();
        if (isCreated) {
            System.out.println("Folder is created successfully");
        } else {
            System.out.println("Error found!");
        }
    }

    public void delete(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                System.out.println("File " + path + " successfully deleted!");
            }
            if (file.isDirectory()) {
                file.delete();
                System.out.println("Folder " + path + " successfully deleted!");
            }
        }
    }

    public void addText(String path, String text) {
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write("\n" + text);
            fw.close();
        } catch (IOException exc) {
            System.err.println("FileWrite exception: " + exc.getMessage());
        }
    }
}