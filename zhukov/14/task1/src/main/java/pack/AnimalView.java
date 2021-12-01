package pack;

import org.springframework.stereotype.Component;
import pack.interfaces.Command;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class AnimalView {

    final String exitPoint = "exit";
    String command ;
    String param = null;
    final Map<String, Method> methods;

    final AnimalService animalService = new AnimalService();

    public AnimalView() throws IOException, InvocationTargetException, IllegalAccessException {
        methods = getAllMethods();
        System.out.println(methods);
        while(this.handleCommand()){
            this.execute();
        }
    }

    public boolean handleCommand(){

        System.out.println("Please enter some command");

        Scanner scanner = new Scanner(System.in);
        String enteredText = scanner.nextLine();

        if(enteredText.equals(exitPoint) ){
            return false;
        }

        if(enteredText.contains("\s")){
            String enteredArgs[] = enteredText.split("\s");
            command = enteredArgs[0];
            param = enteredArgs[1];
        }else{
            command = enteredText;
        }
        return true;
    }

    public void execute() throws IOException, InvocationTargetException, IllegalAccessException {

        if(methods.get(command) != null )  {
            methods.get(command).invoke(animalService, param);
        }else{
            System.out.print("Command wasn't found");
        }
    }

    private Map<String, Method> getAllMethods() {
        Map<String, Method> methods = new HashMap<>();
        for (Method m : animalService.getClass().getDeclaredMethods()) {
            methods.put(m.getName(), m);
        }
        return methods;
    }
}
