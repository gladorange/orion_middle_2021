package lection14.task1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
public class AnimalView {
    final private AnimalService animalService;

    public void workWithUser(){
        System.out.println("Робот помощник приветствует Вас в зоопарке!\n");
        System.out.println(getMethodsDescription());
        handleCommands();
        System.out.println("Досвидания! До новых встреч!\n");
    }

    private void handleCommands() {
        final Map<String, Method> methods = getAnimalMethods();
        while(true) {
            System.out.print(">");
            Scanner myScan = new Scanner(System.in);
            String cmd = myScan.nextLine();
            if(cmd.equals("exit"))
                return;
            if(isBlank(cmd)) {
                System.out.println("Каманда не может быть пустой! Попробуйте ещё раз!");
                continue;
            }
            String[] args = cmd.split(" ");
            String method = args[0];
            Method m = methods.get(method);
            if (m == null) {
                System.out.println("Извините, я Вас не понял! Попробуйте другую команду!");
                continue;
            }
            AnimalMethod am = m.getAnnotation(AnimalMethod.class);
            if(am.argsQuantity() > args.length-1) {
                System.out.println("Извините, недостаточно аргументов для команды!");
                System.out.println(am.name() + " - " + am.description());
                continue;
            }
            if(am.argsQuantity() < args.length-1) {
                System.out.println("Извините, слишком много аргументов для команды!");
                System.out.println(am.name() + " - " + am.description());
                continue;
            }
            try {
                if(am.argsQuantity()==1) {
                    String[] nArgs = Arrays.copyOfRange(args, 1, args.length);
                    System.out.println( m.invoke(animalService, nArgs[0]) );
                } else {
                    System.out.println( m.invoke(animalService) );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private Map<String, Method> getAnimalMethods() {
        final Map<String, Method> methods = new HashMap<>();
        for (Method m : animalService.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(AnimalMethod.class)) {
                AnimalMethod am = m.getAnnotation(AnimalMethod.class);
                methods.put(am.name(), m);
            }
        }
        return methods;
    }

    private String getMethodsDescription() {
        StringBuilder sb = new StringBuilder("Для общения со мной используйте следующие команды:\n");
        for (Method m : animalService.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(AnimalMethod.class)) {
                AnimalMethod am = m.getAnnotation(AnimalMethod.class);
                sb.append(am.name()).append(" - ")
                    .append(am.description()).append("\n");
            }
        }
        sb.append("Для завершения работы напишите: exit\n");
        return sb.toString();
    }

}
