package animals.cli.commands;

import animals.cli.AnimalView;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class Command {
    List<String> args;

    public void run(AnimalView animalView) {
        // Do nothing
    }
}
