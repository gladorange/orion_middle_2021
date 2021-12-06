package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;
import java.util.Arrays;

public class ChangeDir implements Command {

    @Override
    public void execute(String param) {
        ApplicationRegister apReg = ApplicationRegister.getInstance();
        String dir = apReg.get("curDir") ;

        String path ;

        if(param.equals("..")){
            String[] els  = dir.split("\\\\");
            els[els.length-1] = "";
            path = String.join("\\",Arrays.asList(els));;
            System.out.println( path );
        }else{
            path = dir+"\\"+param+"\\";
        }

        File directory = new File(path).getAbsoluteFile();
        if(directory.exists()){
            apReg.set("curDir",directory.toString() );
            System.out.println("Directory was changed. Current path = "+directory );
        }else {
            System.out.println("Directory "+directory+" not exists");
        }

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
