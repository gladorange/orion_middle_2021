package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;

public class LookCurDir implements Command {

    @Override
    public void execute(String param) {

        ApplicationRegister apReg = ApplicationRegister.getInstance();

        System.out.println("There are files in the dir = " + apReg.get("curDir") );
        System.out.println("-------------\\");
        File directory = new File(apReg.get("curDir")).getAbsoluteFile();
        if(directory.exists()){
            for (String s : directory.list()) {
                System.out.println(" - "+s);
            }
        }
        System.out.println("-------------//");
    }
}
