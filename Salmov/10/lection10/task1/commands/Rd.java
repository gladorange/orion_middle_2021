package lection10.task1.commands;

import java.io.File;

public class Rd extends Command{

    public Rd() {
        name = "rd";
    }

    @Override
    public String getHelp() {
        return name + " - удаляет директорию, указанную в параметре (образец: rd dir_name)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            File directory = new File(ss).getAbsoluteFile();
            if(!directory.isDirectory()){
                System.out.println("Директория "+ss+" не найдена или это не директория!");
                return;
            }
            if(directory.delete()){
                System.out.println("Директория "+ss+" была успешно удалена!");
            } else {
                System.out.println("Директория "+ss+" видимо не пустая!");
            }
        }
    }
}
