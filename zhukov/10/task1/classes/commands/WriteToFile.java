package task1.classes.commands;

import task1.classes.ApplicationRegister;
import task1.interfaces.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WriteToFile implements Command {

    @Override
    public void execute(String param) throws IOException {
        ApplicationRegister apReg = ApplicationRegister.getInstance();
        String path = apReg.get("curDir")+"\\"+param;

        File changedFile = new File(path);
        if(!changedFile.exists()){
            System.out.println("File wasn't found");
            return;
        }
        System.out.println("Please enter some text");

        StringBuilder sb = new StringBuilder();
        try(FileInputStream fis = new FileInputStream(changedFile)){
            int res = fis.read();
            while (res!=-1){
                res = fis.read();
                sb.append((char)res );
            }
        }

        System.out.println("--------\\");
        System.out.println("Already in file : "+sb.toString() );
        System.out.println("--------/");

        Scanner scanner = new Scanner(System.in);
        String enteredText = scanner.nextLine();

        try( FileOutputStream fos = new FileOutputStream(changedFile)){
            sb.append(enteredText);
            fos.write( sb.toString().getBytes(StandardCharsets.UTF_8) );
        }
        System.out.println("File was updated");
    }
}
