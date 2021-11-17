package lection10.task1.commands;

import java.io.File;

public class Del extends Command{

    public Del() {
        name = "del";
    }

    @Override
    public String getHelp() {
        return name + " - удаляет файл с именем указанным в параметре (образец: del file_name)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            File file = new File(ss).getAbsoluteFile();
            if(!file.isFile()){
                System.out.println("Файл "+ss+" не найден или это не файл!");
                return;
            }
            if(file.delete()){
                System.out.println("Файл "+ss+" был успешно удалён!");
            } else {
                System.out.println("Файл "+ss+" не удалён!");
            }
        }
    }
}
