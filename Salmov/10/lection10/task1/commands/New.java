package lection10.task1.commands;

import java.io.File;
import java.io.IOException;

public class New extends Command{

    public New() {
        name = "new";
    }

    @Override
    public String getHelp() {
        return name + " - создаёт файл с именем, указанным в параметре (образец: new file_name)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            File file = new File(ss).getAbsoluteFile();
            if(file.exists()){
                System.out.println("Файл "+ss+" уже существует!");
                return;
            }
            try {
                if(file.createNewFile()){
                    System.out.println("Файл "+ss+" был успешно создан!");
                } else {
                    System.out.println("Файл "+ss+" не создан!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
