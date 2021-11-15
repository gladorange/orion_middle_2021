package lection10.task1.commands;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.File;
import java.util.Objects;

public class Look extends Command{

    public Look() {
        name = "look";
    }

    @Override
    public String getHelp() {
        return name + " - показывает файлы в текущей директории или в указанной (образец: look [dir_name])";
    }

    @Override
    public void execute(String s) {
        String ss = s.replace(name, "").trim();
        if( ss.isEmpty()){
            showFilesList(System.getProperty("user.dir"));
        } else {
            showFilesList(ss);
        }
    }

    private void showFilesList(String dir){
        File d = new File(dir).getAbsoluteFile();
        File[] files = d.listFiles();
        if(files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }
}
