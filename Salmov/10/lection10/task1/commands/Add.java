package lection10.task1.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Add extends Command{

    public Add() {
        name = "add";
    }

    @Override
    public String getHelp() {
        return name + " - дозаписывает текст в файл с указанным именем (образец: add file_name text)";
    }

    @Override
    public void execute(String s) {
        String ss = getArgumentsFromCmd(s,name);
        if( !ss.isEmpty()){
            String arg = retrieveNextArg(ss);
            ss = removeArg(ss, arg);
            if( ss.isEmpty() ){
                System.out.println("Не указан текст для добавления в файл!");
                return;
            }

            File file = new File(arg).getAbsoluteFile();
            if(!file.exists()){
                System.out.println("Файл "+arg+" не существует!");
                return;
            }

            try {
                FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                bufferWriter.write(ss);
                bufferWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
