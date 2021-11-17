package lection10.task1.commands;

import java.io.File;

public class Md extends Command{

    public Md() {
        name = "md";
    }

    @Override
    public String getHelp() {
        return name + " - создаёт директорию с именем, указанным в параметре (образец: md dir_name)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            File directory = new File(ss).getAbsoluteFile();
            if(directory.exists() && directory.isDirectory()){
                System.out.println("Директория "+ss+" уже существует!");
                return;
            }
            if(directory.mkdir()){
                System.out.println("Директория "+ss+" была успешно создана!");
            } else {
                System.out.println("Директория "+ss+" не создана!");
            }
        }
    }
}
