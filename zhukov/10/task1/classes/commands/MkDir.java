package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;
import java.io.IOException;

public class MkDir implements Command {

    @Override
    public void execute(String param) throws IOException {
        ApplicationRegister apReg = ApplicationRegister.getInstance();
        String dir = apReg.get("curDir") ,
                path = dir+"\\"+param;

        File newDir = new File(path);
        if( newDir.mkdir()){
            System.out.println("File "+ newDir.getAbsoluteFile()+" was created");
        }else {
            System.out.println("File "+ newDir.getAbsoluteFile()+" already exist");
        }
    }
}