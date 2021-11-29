package task10;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileManager manager = new FileManager();
        List<String> commands = Arrays.asList("List", "CreateFolder", "Delete", "AddText", "Quit");

        System.out.println("Hello, my friend!");
        System.out.println("=================================");
        System.out.println("This is available commands");


        while (true) {

            System.out.println("---------------------------------");
            commands.forEach(System.out::println);
            System.out.println("=================================");
            Scanner scanner = new Scanner(System.in);
            String message = "Enter a command";

            System.out.println(message);
            String command = scanner.nextLine().toLowerCase().trim();
            if (command.isEmpty()) {
                System.out.println("There is no command");
            } else {
                switch (command) {
                    case "list":
                        System.out.println("Enter folder path");
                        manager.list(scanner.nextLine().trim());
                        break;
                    case "createfolder":
                        System.out.println("Enter folder path");
                        manager.createDir(scanner.nextLine().trim());
                        break;
                    case "delete":
                        System.out.println("Enter folder path");
                        manager.delete(scanner.nextLine().trim());
                        break;
                    case "addtext":
                        System.out.println("Enter file path");
                        String path = scanner.nextLine().trim();
                        System.out.println("Enter text");
                        String text = scanner.nextLine().trim();
                        manager.addText(path, text);
                        break;
                    case "quit":
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
