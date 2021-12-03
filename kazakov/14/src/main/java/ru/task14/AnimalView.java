package ru.task14;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
@Configuration
@ComponentScan
public class AnimalView {
    private final AnimalService animalService;

    public AnimalView(AnimalService animalService) {    //  AnimalView зависит от AnimalService
        this.animalService = animalService;
    }

    /*
     * Когда AnimalView запускается - оно спрашивает у пользователя что он хочет сделать
     * с сервисом (предлагает ввести имя метода), выполняет указанный метод и выводит ответ в консоль.
     */
    @PostConstruct
    public void postConstruct() {
        System.out.print("Введите имя метода (getAllCats/getAllDogs/getQuietestCats/getLoudestDogs/getCatsByName [name]/getDogsByName [name]):");
        Scanner scanner = new Scanner(System.in);
        animalService.processUserCommand(scanner.nextLine());
        //  graciously quit:
        System.out.print("Bye!");
    }

    public static void main(String[] args) {
        try {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.scan("ru.task14");
            ctx.refresh();
            AnimalService animalService = ctx.getBean(AnimalView.class).animalService;
            ctx.close();
        } catch (Exception e) {
            System.out.printf("Exception caught: %s\n", e.getMessage());
            e.printStackTrace();
        }
    }
}
