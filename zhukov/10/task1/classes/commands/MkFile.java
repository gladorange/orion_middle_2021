package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;
import java.io.IOException;

public class MkFile implements Command {

    @Override
    public void execute(String param) throws IOException {
        ApplicationRegister apReg = ApplicationRegister.getInstance();
        String dir = apReg.get("curDir") ,
        path = dir+"\\"+param;

        File newFile = new File(path);
        if( newFile.createNewFile()){
            System.out.println("File "+ newFile.getAbsoluteFile()+" was created");
        }else {
            System.out.println("File "+ newFile.getAbsoluteFile()+" already exist");
        }
    }
}
