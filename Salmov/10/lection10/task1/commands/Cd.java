package lection10.task1.commands;

import java.io.File;

public class Cd extends Command{

    public Cd() {
        name = "cd";
    }

    @Override
    public String getHelp() {
        return name + " - изменяет текущую директорию на указанную в параметре (образец: cd d:\\docs\\lection1)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            File directory = new File(ss).getAbsoluteFile();
            if (directory.exists())
            {
                System.setProperty("user.dir", directory.getAbsolutePath());
            } else {
                System.out.println("Дружище, видимо нет такой директории! Проверь пожалуйста!");
            }
        }

    }
}
