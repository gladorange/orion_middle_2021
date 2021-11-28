package animals.cli;

import animals.cli.commands.Command;
import animals.cli.commands.Commands;
import animals.cli.commands.ExitCommand;
import animals.models.Dog;
import animals.services.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class AnimalView {
    private AnimalService animalService;

    public void showAllDogs() {
        List<Dog> allDogs = animalService.findAllDogs();
        allDogs.forEach(System.out::println);
    }

    public void showDogByName(String name) {
        animalService.findDogByName(name)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.printf("Dog %s not found.%n", name));
    }

    public void showAllCats() {
        animalService.findAllCats()
                .forEach(System.out::println);
    }

    public void showCatByName(String name) {
        animalService.findCatByName(name)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.printf("Cat %s not found.%n", name));
    }

    public void showLoudestDog() {
        animalService.findLoudestDog()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No dogs found"));
    }

    public void showQuietestCat() {
        animalService.findQuietestCat()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No cats found"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">>> ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                Command command = Commands.parse(line);
                if (command instanceof ExitCommand) {
                    System.out.println("Good bye!");
                    break;
                }
                command.run(this);
            } catch (Commands.CommandNotFoundException e) {
                System.out.println("Command not found");
            }
            System.out.print(">>> ");
        }

    }

}
