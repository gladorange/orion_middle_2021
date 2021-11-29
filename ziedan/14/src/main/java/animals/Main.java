package animals;

import animals.cli.AnimalView;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ZooConfiguration.class);

        final AnimalView animalView = context.getBean(AnimalView.class);
        animalView.start();
    }
}
