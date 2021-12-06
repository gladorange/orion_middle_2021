package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;
import java.io.IOException;

public class DelFile implements Command {

    @Override
    public void execute(String param) throws IOException {
        ApplicationRegister apReg = ApplicationRegister.getInstance();
        String dir = apReg.get("curDir") ,
                path = dir+"\\"+param;

        File fileObject = new File(path);
        if( fileObject.delete()){
            System.out.println("File "+ path+" was deleted");
        }else {
            System.out.println("File "+ path+" wasn't deleted");
        }
    }
}
